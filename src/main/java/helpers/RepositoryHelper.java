package helpers;

import gitHubPages.PageManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
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

    public String searchKeyWord(String searchedLanguageName) {
        return homePage.searchItem(searchedLanguageName);
    }

    public List<String> getFirstNamesFromList() {
        List<String> firstList = new ArrayList<>();
        for (WebElement item : searchResultPage.getFirstSearchedList()) {
            firstList.add(item.getText());
        }
        return firstList;
    }

    public void applySortFilter() {
        searchResultPage.getSortDropDown();
        searchResultPage.getDropDownItem();
    }

    public List<String> getSecondNamesFromList() {
        List<String> secondList = new ArrayList<>();
        for (WebElement item : searchResultPage.getSecondSearchedList()) {
            secondList.add(item.getText());
        }
        return secondList;
    }

    //countStars
    public List<String> getStarsList() {
        List<String> starsList = new ArrayList<>();
        for (WebElement item : searchResultPage.getStarsCountList()) {
            starsList.add(item.getText());
        }
        return starsList;
    }

    public int countValueOfStars() {
        int sum = 0;
        for (WebElement item : searchResultPage.getStarsCountList()) {
            String str = item.getText();
            if (str.contains("k")) {
                str = item.getText().replace("k", "");
                if (str.contains(".")) {
                    str = str.replace(".", "");
                    sum += Integer.parseInt(str) * 100;
                } else {
                    sum += Integer.parseInt(str) * 1000;
                }
            } else {
                sum += Integer.parseInt(str);
            }
        }
        return sum;
    }

    // concat strings
    @Step ("Get language name and repository count")
    public int getLangRepoValue(String languageName){
      return searchResultPage.getLanguageValue(languageName);
    }



}
