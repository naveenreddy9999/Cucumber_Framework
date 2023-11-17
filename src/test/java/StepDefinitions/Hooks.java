package StepDefinitions;

import Utilities.Drivers;
import Utilities.ConfigPropertiesReader;
import io.cucumber.java.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    public static ConfigPropertiesReader configPropertiesReader = ConfigPropertiesReader.getInstance();

    @Before
    public void beforeScenario(Scenario scenario) {
        log.info("Browser Type :: " + configPropertiesReader.getPropertyValue("Browser"));
        Drivers.getInstance().setDrivers(configPropertiesReader.getPropertyValue("Browser").toUpperCase());
        configPropertiesReader.setScenarioContext("scenario", scenario);
    }

    @After
    public void afterScenario() {
    }

    @AfterAll
    public static void afterAllScenario(){
        Drivers.getInstance().getDriver().quit();
    }

}
