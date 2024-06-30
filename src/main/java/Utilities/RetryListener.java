package Utilities;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.java.Scenario;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {

    int failedCount =0;
    int Limit=1;

    @Override
    public boolean retry(ITestResult result) {

        if (failedCount<Limit){
            if(failedCount==0){
                System.out.println(ExtentCucumberAdapter.getCurrentScenario().toString());
                ExtentService.getInstance().removeTest(ExtentCucumberAdapter.getCurrentScenario());
            }
            failedCount++;
            return true;
        }
        return false;
    }
}
