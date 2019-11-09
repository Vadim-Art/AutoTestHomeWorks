import gitHubPages.BlogPage;
import gitHubPages.GitHubPage;
import gitHubPages.LoginPage;
import gitHubPages.UsersRepositoriesPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestBase {
    ChromeDriver driver;
    LoginPage loginPage;
    GitHubPage gitHubPage;
    BlogPage blogPage;
    UsersRepositoriesPage usersRepositoriesPage;
    WebDriverWait wait;


    @BeforeMethod
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
        loginPage = new LoginPage(driver, wait);
        gitHubPage = new GitHubPage(driver, wait);
        blogPage = new BlogPage(driver, wait);
        usersRepositoriesPage = new UsersRepositoriesPage(driver, wait);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
