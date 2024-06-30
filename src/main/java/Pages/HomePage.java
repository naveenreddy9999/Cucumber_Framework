package Pages;
import Utilities.CommonFunctions;
import Utilities.PropertiesReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class HomePage {

    WebDriver driver;
    CommonFunctions commonFunctions;
    PropertiesReader propertiesReader;
    PropertiesReader propertiesReaderText;
    private final Logger logger = LoggerFactory.getLogger(HomePage.class);
    public HomePage(WebDriver driver){
        this.driver = driver;
        commonFunctions = new CommonFunctions(driver);
        propertiesReader = new PropertiesReader("WebElementsProperties/CommonPage");
        propertiesReaderText = new PropertiesReader("TextDataProperties/CommonPageTextData");
    }

    public void loginApplication(String applicationURL) {
        driver.get(applicationURL);
    }

    public String getElementValue(String element){
        return propertiesReader.getPropertyValue(element);
    }

    public String getTextValue(String element){
        return propertiesReaderText.getPropertyValue(element);
    }

    public void validateAllHeadings() {

        WebElement element = driver.findElement(By.xpath("//h1[contains(text(),'Practice Page')]"));
        System.out.println(element.getText());
        commonFunctions.validateElementText(getElementValue("PP_Title"),getTextValue("PP_Title"));
        List<String> texts = Arrays.asList(getTextValue("PP_SubTitles").split(","));
        commonFunctions.compareTextsAndElements(commonFunctions.getElements(getElementValue("PP_SubTitles")),texts);
        commonFunctions.pageScreenShot("fieldsValidations");
    }

    public void validateRadioButton() {
        commonFunctions.clickOn(commonFunctions.getElements(getElementValue("PP_Radio")).get(0));
        commonFunctions.clickOn(commonFunctions.getElements(getElementValue("PP_Radio")).get(1));
        commonFunctions.clickOn(commonFunctions.getElements(getElementValue("PP_Radio")).get(2));
    }

    public void enterTextOnTextBox(String text) {
        Assert.assertEquals((commonFunctions.getAttribute(getElementValue("PP_TextBoxes"),"placeholder")),getTextValue("PP_TextBox"));
        commonFunctions.sendKeys(commonFunctions.getElement(getElementValue("PP_TextBoxes")), text);

    }

    public void verifyAndValidateAlertPopUp(String message) {
        Assert.assertEquals((commonFunctions.getAttribute(getElementValue("PP_TextBoxes"),"placeholder")),getTextValue("PP_TextBox"));
        commonFunctions.sendKeys(commonFunctions.getElement(getElementValue("PP_TextBoxes")), message);
    }

    public void userHandleTab() {
        commonFunctions.clickOn(commonFunctions.getElement(getElementValue("PP_TAB")));
        commonFunctions.handleWindow();
        commonFunctions.validateTextMessages(driver.getTitle(),"QAClick Academy - A Testing Academy to Learn, Earn and Shine");
        commonFunctions.pageScreenShot("window handle");
        commonFunctions.reTurnToMainWindow();
    }

    public void verifyTotalNumberOfCountries() {
        List<WebElement> listOfCountries = commonFunctions.getElements(getElementValue("PP_Table"));
        logger.info("total Number of countries :: "+ listOfCountries.size());
        List<String> expectedCountries = Arrays.asList(getTextValue("PP_Countries").split(","));
        commonFunctions.compareTextsAndElements(listOfCountries,expectedCountries);
    }
}
