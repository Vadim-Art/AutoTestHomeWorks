import blogPage.BlogPage;
import blogPage.LoginPageForTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.PropertyLoader;

import java.time.Duration;

public class ViewerTest extends TestBase {

    private WebDriverWait wait;

    //private String expectedName = "testautotest";
    //private String expectedUrl = "https://github.com";

    private String expectedName = "The GitHub Blog";
    private String expectedUrl = "https://github.blog/";
    private String url = System.getProperty("gitHub.login.page.url");
    //private String expectedName = "testautotest";
    //private String expectedUrl = "https://github.com";

   // private By usernameInput = By.xpath("//input[@id='login_field']");//By.id("login_field");
   // private By passwordInput = By.xpath("//input[@id='password']"); //By.id("password");
    //private By signinButton = By.xpath("//input [@type = 'submit']");//By.cssSelector(".auth-form-body [name='commit']");
    //private By dropdown = By.xpath("//summary [contains(@aria-label, 'View profile')]"); //By.cssSelector(".details-overlay .Header-link[aria-label*='View profile']");
   // private By targetName = By.xpath("//strong [contains(., 'test')]");//By.cssSelector(".header-nav-current-user .css-truncate-target");
    //private By visibleDropdown = By.xpath("//details-menu [contains (@class,'mt-2')]");// By.cssSelector(".details-overlay .dropdown-menu.mt-2");
    //private By loginForm = By.xpath("//div[@class = 'auth-form-body mt-3']");//By.cssSelector(".auth-form .auth-form-body");

    @Test
    public void userLogin() {
       // driver.get("https://github.com/login");
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm));
       // driver.findElement(usernameInput).sendKeys("testautotest12345@gmail.com");
      //  driver.findElement(passwordInput).sendKeys("qwerty12345auto");
      //  driver.findElement(signinButton).click();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));
       // driver.findElement(dropdown).click();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(visibleDropdown));

        //Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));
        driver.get(url);
        loginPageForTest.userLogin("testautotest12345@gmail.com","qwerty12345auto");
        gitHubPage.selectBlogLink();

        //loginPage.userLogin("testautotest12345@gmail.com","qwerty12345auto");
        //githubPage.selectDropDown();
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
        Assert.assertEquals(blogPage.getPageName(), expectedName);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm));
       // driver.findElement(usernameInput).sendKeys("testautotest12345@gmail.com");
       // driver.findElement(passwordInput).sendKeys("qwerty12345auto");
       // driver.findElement(signInButton).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));
        //driver.findElement(dropdown).click();
       //wait.until(ExpectedConditions.visibilityOfElementLocated(visibleDropdown));
        //String actualUsername = driver.findElement(targetName).getText();

        //String actualUsername = driver.findElement(targetName).getText();

        //Assert.assertEquals(actualUsername, expectedName);
    }
}
