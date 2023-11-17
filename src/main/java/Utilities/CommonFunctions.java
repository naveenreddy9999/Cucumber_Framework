package Utilities;

import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.HashMap;
import java.util.List;

public class CommonFunctions {

    WebDriver driver;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
    }

    public HashMap<String,String> textDetails = new HashMap<>();

    public void setTextDetails(String key,String value){
        textDetails.put(key+Thread.currentThread().getId(),value);
    }

    public String getTextDetails(String key){
        return textDetails.get(key+Thread.currentThread().getId());
    }

    public void pageScreenShot(String screenShotName) {
        Scenario scenario = ConfigPropertiesReader.getInstance().getScenarioContext("scenario");
        byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenShot, "image/png", screenShotName + Thread.currentThread());
    }

    public By getValue(String value){
        String[] configValue = value.split("##");
        assert configValue.length == 2;
        return fetchElement(configValue[0],configValue[1]);
    }

    public By fetchElement(String elementType, String element){
        By by = null;
        switch (elementType.toUpperCase()){
            case "ID":
                by = By.id(element);
                break;
            case "XPATH":
                by = By.xpath(element);
                break;
            case "CLASS":
                by = By.className(element);
                break;
            case "TAGNAME":
                by = By.tagName(element);
                break;
            case "CSSSELECTOR":
                by = By.cssSelector(element);
                break;
            case "PARTIALLINKTEXT":
                by = By.partialLinkText(element);
                break;
            case "LINKTEXT":
                by = By.linkText(element);
                break;
            case "NAME":
                by = By.name(element);
                break;
            default:
                Assert.fail("Invalid WebElement Type :: "+elementType);
                break;
        }
        return by;
    }

    public WebElement getElement(String element){
        WebElement returnElement = driver.findElement(getValue(element));
        return returnElement;
    }

    public List<WebElement> getElements(String elements){
        List<WebElement> returnWebElements = driver.findElements(getValue(elements));
        return returnWebElements;
    }

    public void clickOn(WebElement element){
        if(isDisplayed(element)) {
            element.click();
        }
    }

    public boolean isDisplayed(WebElement element){
        try{
            element.isDisplayed();
            return true;
        }catch (Throwable t){
            return false;
        }
    }
}
