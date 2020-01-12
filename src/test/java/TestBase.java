//import io.qameta.allure.Step;

import io.qameta.allure.Step;
import managers.AppManager;
import managers.SingletonAppManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {
    AppManager app = SingletonAppManager.getInstance().manager;
    WebDriver driver = AppManager.getWebDriver();

    @Step("Running the webdriver")
    @BeforeMethod
    public void before() {
    }

    @Step("quiting the webdriver")
    @AfterMethod
    public void tearDown() {
        AppManager.getWebDriver().quit();
    }

}
