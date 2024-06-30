package StepDefinitions;

import Utilities.CommonFunctions;
import Utilities.Drivers;
import Utilities.ConfigPropertiesReader;
import Utilities.PropertiesReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.java.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    public static ConfigPropertiesReader configPropertiesReader = ConfigPropertiesReader.getInstance();

//    @BeforeAll
//    public static void beforeAllScenario(){
//
//    }




    @Before
    public void beforeScenario(Scenario scenario) {
        log.info("Browser Type :: " + configPropertiesReader.getPropertyValue("Browser"));
        Drivers.getInstance().setDrivers(configPropertiesReader.getPropertyValue("Browser").toUpperCase());
        configPropertiesReader.setScenarioContext("scenario", scenario);

    }

    @After
    public void afterScenario(Scenario scenario) {
        if(scenario.isFailed()){
            CommonFunctions commonFunctions = new CommonFunctions(Drivers.getInstance().getDriver());
            commonFunctions.pageScreenShot(scenario.getName().replace("_"," "));
        }
    }
    @AfterAll
    public static void afterAllScenario(){
//        Drivers.getInstance().getDriver().close();
    }
}
