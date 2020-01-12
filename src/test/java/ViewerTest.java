import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ViewerTest extends TestBase {

    private String expectedName = "testautotest";
    private String expectedUrl = "https://github.com";
    private String expectedName1 = "The GitHub Blog";
    private String expectedUrl1 = "https://github.blog/";
    private int expectedElementsNumber = 4;
    private int expectedFolderNumber = 1;
    private int expectedFilesNumber = 3;
    private int expectedFilesNumberForNewRepo = 1;
    private String expectedUrlForRepository = "https://github.com/testautotest/TestRepository";
    private String expectedUrlForNewRepo = "https://github.com/testautotest/test-repo4";
    private String expectedFileName = "README.md";
    private String expectedFolderName = "src";
    private String expectedIgnoreName = ".gitignore";
    private String expectedPomName = "pom.xml";
    private String expectedUrlForUsersRepo = "https://github.com/Vadim-Art/AutoTestHomeWorks";

    @Test
    public void userLoginWithPageObject() {
        app.getNavigationHelper().goToLoginForm();
        app.getUserHelper().loginAs();
        app.getUserHelper().getDropdown();
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));
        Assert.assertEquals(app.getUserHelper().getUserName(), expectedName);
    }

    @Test
    public void goToBlogTest() {
        app.getNavigationHelper().goToLoginForm();
        app.getUserHelper().loginAs();
        app.getNavigationHelper().getBlogLink();

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl1);
        Assert.assertEquals(app.getRepositoryHelper().getPageTitle(), expectedName1);
    }

    @Test
    public void usersRepositoryCountFileTest() {
        app.getNavigationHelper().goToLoginForm();
        app.getUserHelper().loginAs();
        app.getNavigationHelper().goToUsersRepository();

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlForRepository);
        Assert.assertEquals(app.getRepositoryHelper().getFiles(), expectedElementsNumber);
    }

    @Test
    public void usersRepositoryCountFoldersAndFilesTest() {
        app.getNavigationHelper().goToLoginForm();
        app.getUserHelper().loginAs();
        app.getNavigationHelper().goToUsersRepository();

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlForRepository);
        Assert.assertEquals(app.getRepositoryHelper().getFolder(), expectedFolderNumber);
        Assert.assertEquals(app.getRepositoryHelper().getFilesFromList(), expectedFilesNumber);
    }

    @Test
    public void creatingNewRepositoryTest() {
        app.getNavigationHelper().goToLoginForm();
        app.getUserHelper().loginAs();
        app.getRepositoryHelper().getDropdownCreate();
        app.getRepositoryHelper().getDropdownItem();
        app.getRepositoryHelper().repoCreation();

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlForNewRepo);
        Assert.assertEquals(app.getRepositoryHelper().getFiles(), expectedFilesNumberForNewRepo);
        Assert.assertEquals(app.getRepositoryHelper().getFileTitle(), expectedFileName);
    }

    @Test
    public void searchRepositoryTest() {
        app.getNavigationHelper().goToLoginForm();
        app.getUserHelper().loginAs();
        app.getRepositoryHelper().searchRepo();
        app.getRepositoryHelper().applyFilter();
        app.getRepositoryHelper().getRepoName();

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlForUsersRepo);
        Assert.assertEquals(app.getRepositoryHelper().getFiles(), expectedFilesNumber);
        Assert.assertEquals(app.getRepositoryHelper().getFolderTitle(), expectedFolderName);
        Assert.assertEquals(app.getRepositoryHelper().getFileGitIgnore(), expectedIgnoreName);
        Assert.assertEquals(app.getRepositoryHelper().getFilePom(), expectedPomName);
    }

    @Test
    public void compareTwoSearchedList() throws Exception {
        app.getNavigationHelper().goToHomePage();
        app.getRepositoryHelper().searchKeyWord("Java");
        List<String> firstNamesFromList = app.getRepositoryHelper().getFirstNamesFromList();
        app.getRepositoryHelper().applySortFilter();
        Thread.sleep(5000);
        List<String> secondNamesFromList = app.getRepositoryHelper().getSecondNamesFromList();
        for (int i = 0; i < firstNamesFromList.size(); i++) {
            new SoftAssert().assertNotEquals(firstNamesFromList.get(i), secondNamesFromList.get(i));
        }
    }

    @Test
    public void calculateAllStars() {
        app.getNavigationHelper().goToHomePage();
        app.getRepositoryHelper().searchKeyWord("Java");
        System.out.println("List of the stars is: " + app.getRepositoryHelper().getStarsList());
        System.out.println("Total sum of the stars is: " + app.getRepositoryHelper().countValueOfStars());
        Assert.assertTrue(app.getRepositoryHelper().countValueOfStars() > 0);
    }

    @Test
    @Description("Clearing the search field." +
            "Entering language name into the search field. Clicking the search button." +
            " Getting language name from the list with the number of posts using Xpath," +
            "replacing comma and converting it to INT format")
    public void lang(){
        app.getNavigationHelper().goToHomePage();
        app.getRepositoryHelper().searchKeyWord("Java");
        int languageValue = app.getRepositoryHelper().getLangRepoValue("HTML");
        System.out.println("Searched language count is: " + languageValue);
        Assert.assertTrue(languageValue > 0);
    }
}
