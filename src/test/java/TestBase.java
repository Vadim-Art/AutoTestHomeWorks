import blogPage.BlogPage;
import blogPage.GitHubPage;
import blogPage.LoginPageForTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestBase {
    ChromeDriver driver;
    LoginPageForTest loginPageForTest;
    GitHubPage gitHubPage;
    BlogPage blogPage;
    WebDriverWait wait;

    @BeforeSuite
    public void before() {
        File chromeDriver = new File(System.getProperty("chrome.driver.path"));
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();
        ChromeOptions options = new ChromeOptions().addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(service, options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
        loginPageForTest = new LoginPageForTest(driver, wait);
        gitHubPage = new GitHubPage(driver, wait);
        blogPage = new BlogPage(driver, wait);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
