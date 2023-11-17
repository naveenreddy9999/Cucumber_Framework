package StepDefinitions;

import Pages.HomePage;
import Utilities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomePageStepDefinitions {

    WebDriver driver;
    public HomePage homePage;
    public CommonFunctions commonFunctions;
    TestContext testContext;
    public HomePageStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
        this.homePage = testContext.homePage;
        this.commonFunctions = testContext.commonFunctions;
    }

    @Given("User logon the application")
    public void userLogonTheApplication() {
        homePage.loginApplication(ConfigPropertiesReader.getInstance().getPropertyValue("ApplicationURL"));
        commonFunctions.pageScreenShot("HomePage");
    }
}
