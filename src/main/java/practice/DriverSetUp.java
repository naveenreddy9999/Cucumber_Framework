package practice;

import Utilities.ConfigPropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetUp {

    private static DriverSetUp driverSetUp = null;
    private DriverSetUp(){}
    public static DriverSetUp getInstance(){
        if(driverSetUp == null){
            driverSetUp = new DriverSetUp();
        }
        return driverSetUp;
    }

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static final String ExecutionType = ConfigPropertiesReader.getInstance().getPropertyValue("ExecutionMode").toLowerCase();
    public static final String Browser = ConfigPropertiesReader.getInstance().getPropertyValue("Browser").toLowerCase();
    public synchronized void setUpDriver(){
        System.out.println("Execution Type :: "+ExecutionType);
        switch (ExecutionType){
            case "local":
                if(Browser.equalsIgnoreCase("chrome")){
                    driver.set(new ChromeDriver());
                }else if (Browser.equalsIgnoreCase("firefox")){
                    driver.set(new FirefoxDriver());
                }else if (Browser.equalsIgnoreCase("edge")){
                    driver.set(new EdgeDriver());
                }
                break;
            case "remote":
                if(Browser.equalsIgnoreCase("chrome")){
                    try {
                        driver.set(new RemoteWebDriver(new URL("http://192.168.1.11:4444/wd/hub"),desiredCapabilities(Browser)));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }else if (Browser.equalsIgnoreCase("firefox")){
                    driver.set(new FirefoxDriver());
                }else if (Browser.equalsIgnoreCase("edge")){
                    driver.set(new EdgeDriver());
                }
                break;
        }
    }

    public synchronized WebDriver getDriver(){
        return driver.get();
    }

    public DesiredCapabilities desiredCapabilities(String browserName){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName(browserName);
        return capabilities;
    }

    public static void main(String[] args) {
        DriverSetUp.getInstance().setUpDriver();
        WebDriver driver = DriverSetUp.getInstance().getDriver();
        SessionId sessionId = ((RemoteWebDriver)driver).getSessionId();
        System.out.println(sessionId);
        driver.get("https://mvnrepository.com/");
        System.out.println(driver.getTitle());

        WebElement element = driver.findElement(By.xpath(""));

//        element.click();
        element.submit();
    }
}
