package StepDefinitions;

import Utilities.CommonFunctions;
import Utilities.Drivers;
import Utilities.PropertiesReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonStepDefinitions {

    CommonFunctions commonFunctions;
    PropertiesReader propertiesReader;
    WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(CommonStepDefinitions.class);
    public CommonStepDefinitions(){
        this.driver = Drivers.getInstance().getDriver();
        commonFunctions = new CommonFunctions(driver);
        propertiesReader = new PropertiesReader("WebElementsProperties/CommonPage");
    }

    public WebElement getElement(String elementName){
        return commonFunctions.getElement(propertiesReader.getPropertyValue(elementName));
    }
    @When("User click on the {string} button")
    public void userClickOnTheButton(String buttonType) {
        switch (buttonType.toLowerCase()){
            case "home":
                commonFunctions.clickOn(getElement("HomeBtn"));
                break;
            case "confirm":
                commonFunctions.clickOn(getElement("PP_ConfirmBtn"));
                break;
            case "alert":
                commonFunctions.clickOn(getElement("PP_AlertBtn"));
                break;
            default:
                Assert.fail("Invalid Button Type :: "+buttonType);
                break;

        }
        commonFunctions.pageScreenShot(buttonType);
    }

    @Then("I handled alert {string} with alert {string}")
    public void iHandledAlertWithAlert(String alertType, String alertMessage) {
        switch (alertType.toLowerCase()){
            case "accept":
                commonFunctions.alertAccept();
                break;
            case "dismiss":
                logger.info("Alert Dismiss");
                commonFunctions.alertDismiss();
                break;
            case "sendKeys":
                commonFunctions.alertSendKeys(alertMessage);
                break;
            case "getText":
                logger.info("Alert text :: " +commonFunctions.alertGetText());
                break;
            case "alert":
                commonFunctions.alertPopUp();
            default:
                Assert.fail("Invalid alert method type :: "+alertType);
                break;
        }
        commonFunctions.pageScreenShot(alertType);
    }
}
