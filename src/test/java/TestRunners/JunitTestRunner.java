package TestRunners;


import StepDefinitions.Hooks;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import tech.grasshopper.pdf.extent.ExtentPDFCucumberReporter;

import java.io.*;
import java.util.Properties;

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
    public  static ExtentReports extentReports;

    @BeforeClass
    public static void nnn(){

//        static {
//        System.setProperty("basefolder.name","naveen/Report_");
//        System.setProperty("basefolder.datetimepattern","d-MMM-YY HH-mm-ss");

//            try {
////                Properties properties = new Properties();
////                InputStream inputStream = JunitTestRunner.class.getResourceAsStream("C:\\Users\\NAVEBAND\\IdeaProjects\\CucumberFramework\\src\\test\\resources\\extent.properties");
////                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
////                FileReader reader1 = new FileReader("C:\\Users\\NAVEBAND\\IdeaProjects\\CucumberFramework\\src\\test\\resources\\extent.properties");
//
//                FileInputStream output = new FileInputStream("C:\\Users\\NAVEBAND\\IdeaProjects\\CucumberFramework\\src\\test\\resources\\extent.properties");
//
//                Properties prop = new Properties();
//                prop.load(output);
//
//                prop.remove(prop.getProperty("basefolder.name"));
//
//                prop.setProperty("basefolder.name","reddy/Report_");
//
//
//                FileOutputStream outputStream = new FileOutputStream("C:\\Users\\NAVEBAND\\IdeaProjects\\CucumberFramework\\src\\test\\resources\\extent.properties");
//                prop.store(outputStream, null);
//                System.out.println(prop.getProperty("basefolder.name"));
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        ExtentHtmlReporter reporter = new ExtentHtmlReporter("${basefolder}/file.html");

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);

        ExtentTest test = extentReports.createTest("navee");
        test.info("reddy");

    }

    @AfterClass
    public static void afterClass(){
        extentReports.flush();
    }

}
