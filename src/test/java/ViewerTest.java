import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

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

    @Test
    public void userLoginWitPageObject(){
        driver.get("https://github.com/login");
        loginPage.userLogin();
        gitHubPage.selectDropDown();

        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));
        Assert.assertEquals(gitHubPage.getUserNameFromDropDown(), expectedName);
    }

    @Test
    public void userLoginTest() {

        driver.get(url);
        loginPage.userLogin();
        gitHubPage.selectBlogLink();

        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl1);
        Assert.assertEquals(blogPage.getPageName(), expectedName1);
    }

    @Test
    public void usersRepositoryCountFileTest() {
        driver.get(url);
        loginPage.userLogin();
        gitHubPage.selectUsersRepository();

        Assert.assertEquals(driver.getCurrentUrl(),expectedUrlForRepository);
        Assert.assertEquals(usersRepositoriesPage.getUserFiles(), expectedElementsNumber);
    }
    @Test
    public void usersRepositoryCountFoldersAndFilesTest() {
        driver.get(url);
        loginPage.userLogin();
        gitHubPage.selectUsersRepository();

        Assert.assertEquals(driver.getCurrentUrl(),expectedUrlForRepository);
        Assert.assertEquals(usersRepositoriesPage.getUserFolder(), expectedFolderNumber);
        Assert.assertEquals(usersRepositoriesPage.getUsersFiles(),expectedFilesNumber);
    }
}
