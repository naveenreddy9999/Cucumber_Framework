package StepDefinitions;

import Utilities.CommonFunctions;
import Utilities.PropertiesReader;
import Utilities.TestContext;
import io.cucumber.java.en.When;

public class CommonStepDefinitions {
    TestContext testContext;
    CommonFunctions commonFunctions;
    PropertiesReader propertiesReader;

    public CommonStepDefinitions(TestContext testContext){
        this.testContext = testContext;
        this.commonFunctions = testContext.commonFunctions;
        propertiesReader = new PropertiesReader("WebElementsProperties/CommonPage");
    }
    @When("User click on the {string} button")
    public void userClickOnTheButton(String buttonType) {
        switch (buttonType.toLowerCase()){
            case "home":
                commonFunctions.clickOn(commonFunctions.getElement(propertiesReader.getPropertyValue("HomeBtn")));
                break;
        }
        commonFunctions.pageScreenShot(buttonType);
    }
}
