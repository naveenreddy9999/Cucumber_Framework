package StepDefinitions;

import Pages.HomePage;
import Utilities.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class HomePageStepDefinitions {

    WebDriver driver;
    public HomePage homePage;
    public CommonFunctions commonFunctions;
    public HomePageStepDefinitions() {
        this.driver = Drivers.getInstance().getDriver();
        this.homePage = new HomePage(driver);
        this.commonFunctions = new CommonFunctions(driver);
    }

    @Given("User logon the application")
    public void userLogonTheApplication() {
        homePage.loginApplication(ConfigPropertiesReader.getInstance().getPropertyValue("ApplicationURL"));
        commonFunctions.titleIs("Practice Page");
        commonFunctions.pageScreenShot("HomePage");
    }

    @And("User navigating to practice page")
    public void userNavigatingToPracticePage() {
        driver.navigate().back();
        commonFunctions.pageScreenShot("practicePage");
    }

    @Then("validate each and every heading")
    public void validateEachAndEveryHeading() {
       homePage.validateAllHeadings();
    }

    @Then("Validate radio buttons")
    public void validateRadioButtons() {
        homePage.validateRadioButton();
    }
    @And("User enter text on text box")
    public void userEnterTextOnTextBox(DataTable dataTable) {
        List<Map<String,String>> map = dataTable.asMaps(String.class,String.class);
        for(Map<String, String> data: map)
        homePage.enterTextOnTextBox(data.get("Text"));
    }

    @Then("User checking the alert popup {string}")
    public void userCheckingTheAlertPopup(String message) {
        homePage.verifyAndValidateAlertPopUp(message);
    }

    @Then("User handleTab")
    public void userHandleTab() {
        homePage.userHandleTab();
    }

    @And("User validated total countries of the table")
    public void userValidatedTotalCountriesOfTheTable() {
        homePage.verifyTotalNumberOfCountries();
    }
}
