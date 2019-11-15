import managers.AppManager;
import managers.SingletonAppManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    AppManager app = SingletonAppManager.getInstance().manager;
    WebDriver driver = AppManager.getWebDriver();


    @BeforeMethod
    public void before() {
    }

    @AfterMethod
    public void tearDown() {
        AppManager.getWebDriver().quit();
    }

}
