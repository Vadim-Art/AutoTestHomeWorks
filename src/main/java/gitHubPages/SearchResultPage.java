package gitHubPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultPage extends Page {

    @FindBy(css = ".filter-item")
    private WebElement languageFilter;
    @FindBy(xpath = "//a[contains(text(),'Vadim-Art/')]")
    private WebElement searchedRepoName;


    SearchResultPage(PageManager pages) {
        super(pages);
    }

    public void selectLanguageFilter() {
        wait.until(ExpectedConditions.visibilityOf(languageFilter));
        languageFilter.click();
    }

    public void selectSearchedRepoName() {
        wait.until(ExpectedConditions.visibilityOf(searchedRepoName));
        searchedRepoName.click();
    }

    //search keyword java
    @FindBy(css = "a[class ='v-align-middle']")
    private List<WebElement> firstSearchedList;

    public List<WebElement> getFirstSearchedList(){
        wait.until(ExpectedConditions.visibilityOf(firstSearchedList.get(0)));
        return firstSearchedList;
    }

    @FindBy(css=".btn-sm.select-menu-button")
    private WebElement sortDropdown;

    public void getSortDropDown(){
        wait.until(ExpectedConditions.visibilityOf(sortDropdown));
        sortDropdown.click();
    }

    @FindBy(css = ".select-menu-modal")
    private WebElement openedSortDropDown;

    @FindBy (xpath = "//span[contains(text(),'Fewest stars')]")
    private WebElement dropdownItem;

    public void getDropDownItem () {
        wait.until(ExpectedConditions.visibilityOf(openedSortDropDown));
        dropdownItem.click();
    }

    @FindBy (css = "a[class ='v-align-middle']")
    private List<WebElement> secondSearchedList;

    public List<WebElement> getSecondSearchedList(){
        wait.until(ExpectedConditions.visibilityOf(secondSearchedList.get(0)));
        return secondSearchedList;
    }


}