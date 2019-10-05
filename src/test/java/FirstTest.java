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

    private static ChromeDriver driver;
    private WebDriverWait wait;

    private String expectedName = "testautotest";
    private String expectedUrl = "https://github.com";

    //private By usernameInput = By.id("login_field");
    private By usernameInput = By.xpath("//input[@id='login_field']");
    //private By passwordInput = By.id("password");
    private By passwordInput = By.xpath("//input[@id='password']");
    //private By singinButton = By.cssSelector(".auth-form-body [name='commit']");
    private By signinButton = By.xpath("//input [@type = 'submit']");
    //private By dropdown = By.cssSelector(".details-overlay .Header-link[aria-label*='View profile']");
    private By dropdown = By.xpath("//summary [contains(@aria-label, 'View profile')]");
    //private By targetName = By.cssSelector(".header-nav-current-user .css-truncate-target");
    private By targetName = By.xpath("//strong [contains(., 'test')]");
    //private By visibleDropdown = By.cssSelector(".details-overlay .dropdown-menu.mt-2");
    private By visibleDropdown = By.xpath("//details-menu [contains (@class,'mt-2')]");
    //private By loginForm = By.cssSelector(".auth-form .auth-form-body");
    private By loginForm = By.xpath("//div[@class = 'auth-form-body mt-3']");


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chrome/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);

        driver.get("https://github.com/login");
    }


    @Test
    public void userLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm));
        driver.findElement(usernameInput).sendKeys("testautotest12345@gmail.com");
        driver.findElement(passwordInput).sendKeys("qwerty12345auto");
        driver.findElement(signinButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));
        driver.findElement(dropdown).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(visibleDropdown));

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
