package SeleniumPractice;

import Utilities.PropertiesReader;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {

    @Test
    public  void mainClass(){
        WebDriver driver;
        String type =  PropertiesReader.getInstance().getPropertyValue("Browser");
        switch (type.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                driver.get("https://mvnrepository.com/");
                break;
            case "firefox":
                driver = new FirefoxDriver();
                driver.get("https://mvnrepository.com/");
                break;
            case "edge":
                driver = new EdgeDriver();
                driver.get("https://mvnrepository.com/");
                break;
        }
    }
}
