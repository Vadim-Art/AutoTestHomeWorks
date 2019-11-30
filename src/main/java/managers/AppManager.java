package managers;

import helpers.NavigationHelper;
import helpers.RepositoryHelper;
import helpers.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AppManager {

    private static WebDriver driver;
    private UserHelper userHelper;
    private NavigationHelper navigationHelper;
    private RepositoryHelper repositoryHelper;

    AppManager() {
        //File chromeDriver = new File(PropertyLoader.loadProperty("chrome.driver.path"));
        File chromeDriver = new File(System.getProperty("chrome.driver.path"));
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();
        ChromeOptions options = new ChromeOptions().addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(service, options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        userHelper = new UserHelper();
        navigationHelper = new NavigationHelper();
        repositoryHelper = new RepositoryHelper();
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public NavigationHelper getNavigationHelper(){
        return navigationHelper;
    }
    public RepositoryHelper getRepositoryHelper() {
        return repositoryHelper;
    }
}
