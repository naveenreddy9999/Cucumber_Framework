package Utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Drivers {

    public  static Drivers drivers = null;

    private Drivers(){
    }

    public static Drivers getInstance(){
        if(drivers == null){
            drivers = new Drivers();
        }

        return drivers;
    }

    private final InheritableThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();

    public void setDrivers(String browser){
        switch (browser){
            case "CHROME":
                driver.set(new ChromeDriver());
                break;
            case "FIREFOX":
                driver.set(new FirefoxDriver());
                break;
            case "EDGE":
                driver.set(new EdgeDriver());
                break;
            default:
                Assert.fail("Browser name is not matching with required browsers ");
        }
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get().manage().window().maximize();
    }

    public synchronized WebDriver getDriver(){
        return driver.get();
    }
}
