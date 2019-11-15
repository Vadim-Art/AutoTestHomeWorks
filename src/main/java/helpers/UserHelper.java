package helpers;

import gitHubPages.PageManager;
import managers.AppManager;

public class UserHelper extends PageManager {

    public UserHelper() {
        super(AppManager.getWebDriver());
    }

    // login test
    public void LoginAs() {
        loginPage.userLogin();
    }

    public void getDropdown() {
        gitHubPage.selectDropDown();
    }

    public String getUserName() {
        return gitHubPage.getUserNameFromDropDown();
    }

    //login + go to blog link test

    public void getBlogLink() {
        gitHubPage.selectBlogLink();
    }

    public String getPageTitle() {
        return blogPage.getPageName();
    }

    //usersRepositoryCountFileTest

    public void getUsersRepository() {
        gitHubPage.selectUsersRepository();
    }

    public int getFiles() {
        return usersRepositoriesPage.getUserFiles();
    }

    //usersRepositoryCountFoldersAndFilesTest

    public int getFolder() {
        return usersRepositoriesPage.getUserFolder();
    }

    public int getFilesFromList() {
        return usersRepositoriesPage.getUsersFiles();
    }

}
