import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class seleniumPractice {

    public static void main(String[] args) {

        String k = "hello naveen";
       char[] chars = k.toCharArray();
       for(int i=chars.length-1;i>=0;i--){
           System.out.print(chars[i]);
       }

    }

    @Test
    public void allMethods() throws IOException {
        System.setProperty("webdriver.chrome.driver","");

        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);
        driver.getTitle();
        driver.getWindowHandle();
        driver.close();
        driver.quit();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(20));

        wait.until(ExpectedConditions.alertIsPresent());

        wait.until(ExpectedConditions.titleIs(""));

        List<WebElement> webElementList = driver.findElements(By.xpath(""));

        wait.until(ExpectedConditions.visibilityOfAllElements(webElementList));

        wait.until(ExpectedConditions.visibilityOf(webElementList.get(0)));

        wait.until(ExpectedConditions.elementToBeClickable(webElementList.get(0)));

        wait.until(ExpectedConditions.attributeContains(webElementList.get(0),"name","naveen"));

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.switchTo().frame("");
        driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();
        driver.switchTo().window("");

        Set<String> stringSet = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();
        for (String windows : stringSet){
            if(!parentWindow.equals(windows)){
                driver.switchTo().window(windows);

                // perform

                driver.close();

                break;
            }
        }

        driver.switchTo().window(parentWindow);

        File takesScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(takesScreenshot,new File(".png"));

        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        javascriptExecutor.executeScript("arguments[0].click()",webElementList);

        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",webElementList);

        javascriptExecutor.executeScript("window.scrollBy(0,200)");
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        javascriptExecutor.executeScript("window.scrollTo(500,400)");



    }
}
