package gitHubPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

}
