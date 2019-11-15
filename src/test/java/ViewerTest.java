import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewerTest extends TestBase {

    private String expectedName = "testautotest";
    private String expectedUrl = "https://github.com";

    private String expectedName1 = "The GitHub Blog";
    private String expectedUrl1 = "https://github.blog/";
    private String url = System.getProperty("gitHub.login.page.url");
    private int expectedElementsNumber = 4;
    private int expectedFolderNumber = 1;
    private int expectedFilesNumber = 3;
    private int expectedFilesNumberForNewRepo = 1;
    private String expectedUrlForRepository = "https://github.com/testautotest/TestRepository";
    private String expectedUrlForNewRepo = "https://github.com/testautotest/test-repo3";
    private String expectedFileName = "README.md";
    private String expectedFolderName = "src";
    private String expectedIgnoreName = ".gitignore";
    private String expectedPomName = "pom.xml";
    private String expectedUrlForUsersRepo = "https://github.com/Vadim-Art/AutoTestHomeWorks";

    @Test
    public void userLoginWitPageObject() {
        driver.get("https://github.com/login");
        app.getUserHelper().LoginAs();
        app.getUserHelper().getDropdown();
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));
        Assert.assertEquals(app.getUserHelper().getUserName(), expectedName);
    }

    @Test
    public void userLoginTest() {
        driver.get(url);
        app.getUserHelper().LoginAs();
        app.getUserHelper().getBlogLink();

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl1);
        Assert.assertEquals(app.getUserHelper().getPageTitle(), expectedName1);
    }

    @Test
    public void usersRepositoryCountFileTest() {
        driver.get(url);
        app.getUserHelper().LoginAs();
        app.getUserHelper().getUsersRepository();

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlForRepository);
        Assert.assertEquals(app.getUserHelper().getFiles(), expectedElementsNumber);
    }

    @Test
    public void usersRepositoryCountFoldersAndFilesTest() {
        driver.get(url);
        app.getUserHelper().LoginAs();
        app.getUserHelper().getUsersRepository();

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlForRepository);
        Assert.assertEquals(app.getUserHelper().getFolder(), expectedFolderNumber);
        Assert.assertEquals(app.getUserHelper().getFilesFromList(), expectedFilesNumber);
    }
}
