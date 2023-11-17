package Pages;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void loginApplication(String applicationURL) {
        driver.get(applicationURL);
    }
}
