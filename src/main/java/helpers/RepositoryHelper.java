package helpers;

import gitHubPages.PageManager;
import managers.AppManager;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RepositoryHelper extends PageManager {
    public RepositoryHelper() {
        super(AppManager.getWebDriver());
    }

    // login test

    //login + go to blog link test

    public String getPageTitle() {
        return blogPage.getPageName();
    }

    //usersRepositoryCountFileTest

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

        creatingNewRepositoryPage.enterRepoName();
        creatingNewRepositoryPage.enterRepoDescription();
        creatingNewRepositoryPage.addCheckState();
        creatingNewRepositoryPage.submitRepoCreating();
    }

    public String getFileTitle() {
        return usersRepositoriesPage.getFileName();
    }


    //searchRepository test

    public void searchRepo() {
        gitHubPage.searchItem();
    }

    public void applyFilter() {
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

    // compare two list

    public void searchKeyWord(){homePage.searchItem();}
    public List<String> getFirstNamesFromList(){
        List<String> firstList = new ArrayList<>();
        for (WebElement item: searchResultPage.getFirstSearchedList()){
            firstList.add(item.getText());
        }
        return firstList;
    }

    public void applySortFilter() {
        searchResultPage.getSortDropDown();
        searchResultPage.getDropDownItem();
    }

    public List<String> getSecondNamesFromList(){
        List<String> secondList = new ArrayList<>();
        for (WebElement item: searchResultPage.getSecondSearchedList()){
            secondList.add(item.getText());
        }
        return secondList;
    }


}
