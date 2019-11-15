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

    //creatingNewRepository test

    public void getDropdownCreate() {
        gitHubPage.openDropdownCreate();
    }

    public void getDropdownItem() {
        gitHubPage.selectDropdownItem();
    }

    public void repoCreation() {
        creatingNewRepositoryPage.createRepository();
    }

    public String getFileTitle() {
        return usersRepositoriesPage.getFileName();
    }

    //searchRepository test

    public void search() {
        gitHubPage.searchItem();
    }

    public void getFilter() {
        searchResultPage.selectLanguageFilter();
    }

    public void getRepoName() {
        searchResultPage.selectSearchedRepoName();
    }

    public String getFolderTitle() {
        return usersRepositoriesPage.getFolderName();
    }

    public String getFileGitIgnore() {
        return usersRepositoriesPage.getIgnoreFileName();
    }

    public String getFilePom() {
        return usersRepositoriesPage.getPomFileName();
    }
}
