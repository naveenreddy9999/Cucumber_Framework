package Utilities;

import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class CommonFunctions {

    WebDriver driver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    private final Logger log = LoggerFactory.getLogger(CommonFunctions.class);
    Alert alert;
    String parentWindow;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
    }

    public HashMap<String, String> textDetails = new HashMap<>();

    public void setTextDetails(String key, String value) {
        textDetails.put(key + Thread.currentThread().getId(), value);
    }

    public String getTextDetails(String key) {
        return textDetails.get(key + Thread.currentThread().getId());
    }

    public void pageScreenShot(String screenShotName) {
        try {
            Scenario scenario = ConfigPropertiesReader.getInstance().getScenarioContext("scenario");
            byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", screenShotName + Thread.currentThread());
        }catch (Throwable t){
            log.info("screenShot is not taking");
            throw new RuntimeException();
        }
    }

    public By getValue(String value) {
        String[] configValue = value.split("##");
        assert configValue.length == 2;
        return fetchElement(configValue[0], configValue[1]);
    }

    public By fetchElement(String elementType, String element) {
        By by = null;
        switch (elementType.toUpperCase()) {
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
                Assert.fail("Invalid WebElement Type :: " + elementType);
                break;
        }
        return by;
    }

    public WebElement getElement(String element) {
        return driver.findElement(getValue(element));
    }

    public List<WebElement> getElements(String elements) {
        return driver.findElements(getValue(elements));
    }

    public void waitVisibilityOfElement(WebElement element) {
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementToBeClickable(WebElement element) {
        fluentWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOn(WebElement element) {
        waitVisibilityOfElement(element);
        waitElementToBeClickable(element);
        highlightElement(element);
        try {
            if (isDisplayed(element)) {
                element.click();
            }
        } catch (NoSuchElementException | StaleElementReferenceException | ElementClickInterceptedException e) {
            clickOn(element);
        } catch (Throwable t) {
            t.printStackTrace();
            Assert.fail("Element is not a present in a UI " + element);
        }
    }

    public boolean isDisplayed(WebElement element) {
        boolean isPresent;
        waitVisibilityOfElement(element);
        try {
            element.isDisplayed();
            isPresent = true;
        } catch (Throwable t) {
            isPresent = false;
        }
        return isPresent;
    }

    public boolean isEnabled(WebElement element) {
        boolean isPresent;
        waitVisibilityOfElement(element);
        try {
            element.isEnabled();
            isPresent = true;
        } catch (Throwable t) {
            isPresent = false;
        }
        return isPresent;
    }

    public boolean isSelected(WebElement element) {
        boolean isPresent;
        waitVisibilityOfElement(element);
        try {
            element.isSelected();
            isPresent = true;
        } catch (Throwable t) {
            isPresent = false;
        }
        return isPresent;
    }

    public void sendKeys(WebElement element, String text) {
        waitVisibilityOfElement(element);
        try {
            element.clear();
            element.sendKeys(Keys.TAB);
            element.sendKeys(text);
            element.sendKeys(Keys.TAB);
        } catch (NoSuchElementException | StaleElementReferenceException | ElementClickInterceptedException e) {
            sendKeys(element, text);
        } catch (Throwable t) {
            t.printStackTrace();
            Assert.fail("Element is not a present in a UI " + element);
        }
    }

    public String getText(WebElement element) {
//        waitVisibilityOfElement(element);
//        validateElement(element);
        String text = null;
        try {
            text = element.getText();
            log.info("Element Text : " + text);
        } catch (NoSuchElementException | StaleElementReferenceException | ElementClickInterceptedException e) {
            text = getText(element);
        } catch (Throwable t) {
            t.printStackTrace();
            Assert.fail("Element is not a present in a UI " + element);
        }
        return text;
    }

    public void handleDropDowns(WebElement element, List<WebElement> elements, String text) {
        clickOn(element);
        fluentWait.until(ExpectedConditions.visibilityOfAllElements(elements));
        boolean isPresent = true;
        for (int i = 0; i < elements.size(); i++) {
            if (getText(elements.get(i)).equals(text)) {
                clickOn(element);
                isPresent = true;
                break;
            } else {
                isPresent = false;
            }
        }
        if (!isPresent) {
            Assert.fail("Element is not Displayed in the DropDown :: " + element);
        }
    }

    public void titleIs(String title) {
        try {
            fluentWait.until(ExpectedConditions.titleIs(title));
        } catch (TimeoutException e) {
            titleIs(title);
        }
    }

    public void highlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

    }

    public void validateElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');", element);

    }

    public void validateElementText(String element, String expectedText) {
        Assert.assertEquals(getText(getElement(element)), expectedText);
    }

    public void validateElementText(List<WebElement> elements, String expectedText) {
        boolean isPresent = true;
        for (WebElement element : elements) {
            if (getText(element).equals(expectedText)) {
                isPresent = true;
                break;
            }
        }
        if (!isPresent) {
            Assert.fail("Element is not a matching with any of the element :: " + expectedText);
        }
    }

    public void compareTextsAndElements(List<WebElement> pp_subTitles, List<String> texts) {
        Assert.assertEquals(pp_subTitles.size(), texts.size());
        boolean isPresent = true;
        for (int i = 0; i < pp_subTitles.size(); i++) {
            String element = getText(pp_subTitles.get(i));
            for (int j = 0; j < texts.size(); j++) {
                if (element.equals(texts.get(j))) {
                    log.info("Actual text :: " + texts.get(i) + " Expected text :: " + element);
                    isPresent = true;
                }
            }
            if (!isPresent) {
                Assert.fail("Element is not a matching with any of the element :: " + texts);
            }
        }
    }

    public String getAttribute(String pp_textBox, String pp_placeHolder) {
       return getElement(pp_textBox).getAttribute(pp_placeHolder);
    }

    public void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public void alertSendKeys(String alertMessage){
        driver.switchTo().alert().sendKeys(alertMessage);
    }

    public void alertAccept(){
        driver.switchTo().alert().accept();
    }

    public String alertGetText(){
        return  driver.switchTo().alert().getText();
    }

    public void alertPopUp() {
        alert = driver.switchTo().alert();
    }

    public void handleWindow(){
        parentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String childWindow : windows) {
            if (!childWindow.equals(parentWindow)) {
                driver.switchTo().window(childWindow);
                log.info(driver.switchTo().window(childWindow).getTitle());
            }
        }
    }
    public void reTurnToMainWindow(){
        driver.close();
        driver.switchTo().window(parentWindow);
        log.info(driver.getTitle());
    }

    public void validateTextMessages(String expected ,String actual){
        Assert.assertEquals(expected,actual);
    }
}
