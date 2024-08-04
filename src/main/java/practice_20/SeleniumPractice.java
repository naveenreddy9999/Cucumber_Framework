package practice_20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumPractice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.javatpoint.com/prime-number-program-in-java");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

        List<WebElement> linkElements =driver.findElements(By.tagName("a"));
         wait.until(ExpectedConditions.visibilityOfAllElements(linkElements));
        for (WebElement element : linkElements){
            System.out.println(element.getAttribute("href"));
        }

//        driver.quit();

    }
}
