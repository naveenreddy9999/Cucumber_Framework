package TestRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:Features"},
              glue = {"classpath:StepDefinitions"},
              plugin = {
                      "json:target/cucumber-reports/Cucumber.json",
                      "html:target/cucumber-reports/Cucumber.html",
                      "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
              stepNotifications = true,
              dryRun = false,
              monochrome = true,
              tags = "@LogIn")

public class JunitTestRunner {

}
