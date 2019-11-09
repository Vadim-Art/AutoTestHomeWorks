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

    private String expectedName = "testautotest";
    private String expectedUrl = "https://github.com";

    private String expectedName1 = "The GitHub Blog";
    private String expectedUrl1 = "https://github.blog/";
    private String url = System.getProperty("gitHub.login.page.url");
    private int expectedElementsNumber = 4;
    private int expectedFolderNumber = 1;
    private int expectedFilesNumber = 3;
    private String expectedUrlForRepository = "https://github.com/testautotest/TestRepository";

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
    public void userLoginWitPageObject(){
        driver.get("https://github.com/login");
        loginPageForTest.userLogin();
        gitHubPage.selectDropDown();

        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));
        Assert.assertEquals(gitHubPage.getUserNameFromDropDown(), expectedName);
    }

    @Test
    public void userLoginTest() {

        driver.get(url);
        loginPageForTest.userLogin();
        gitHubPage.selectBlogLink();

        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl1);
        Assert.assertEquals(blogPage.getPageName(), expectedName1);
    }

    @Test
    public void usersRepositoryCountFileTest() {
        driver.get(url);
        loginPageForTest.userLogin();
        gitHubPage.selectUsersRepository();

        Assert.assertEquals(driver.getCurrentUrl(),expectedUrlForRepository);
        Assert.assertEquals(usersRepositoriesPage.getUserFiles(), expectedElementsNumber);
    }
    @Test
    public void usersRepositoryCountFoldersAndFilesTest() {
        driver.get(url);
        loginPageForTest.userLogin();
        gitHubPage.selectUsersRepository();

        Assert.assertEquals(driver.getCurrentUrl(),expectedUrlForRepository);
        Assert.assertEquals(usersRepositoriesPage.getUserFolder(), expectedFolderNumber);
        Assert.assertEquals(usersRepositoriesPage.getUsersFiles(),expectedFilesNumber);
    }

}
