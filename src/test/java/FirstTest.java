import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {

    private static WebDriver driver;

    private String expectedName = "testautotest";
    private String expectedUrl = "https://github.com";

    private By usernameInput = By.id("login_field");
    private By passwordInput = By.id("password");
    private By singinButton = By.cssSelector(".auth-form-body [name='commit']");
    private By dropdown = By.cssSelector(".details-overlay .Header-link[aria-label*='View profile']");
    private By targetName = By.cssSelector(".header-nav-current-user .css-truncate-target");


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chrome/chromedriver.exe");
        ChromeOptions capabilities = new ChromeOptions();
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
    }


    @Test
    public void userLogin() {
        driver.findElement(usernameInput).sendKeys("testautotest12345@gmail.com");
        driver.findElement(passwordInput).sendKeys("qwerty12345auto");
        driver.findElement(singinButton).click();
        driver.findElement(dropdown).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".details-overlay .dropdown-menu.mt-2")));

        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));

        String actualUsername = driver.findElement(targetName).getText();

        Assert.assertEquals(actualUsername, expectedName);
    }

    @AfterMethod
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
