package Utilities;

import Pages.CommonPages;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;

public class TestContext {

    public HomePage homePage;
    public CommonPages commonPages;
    public CommonFunctions commonFunctions;
    WebDriver driver;

    public TestContext() {
        this.driver = Drivers.getInstance().getDriver();
        homePage = new HomePage(driver);
        commonPages = new CommonPages(driver);
        commonFunctions = new CommonFunctions(driver);
    }

}
