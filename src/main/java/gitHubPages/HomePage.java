package gitHubPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Page {
    HomePage(PageManager pages) {
        super(pages);
    }

    private String searchKeyWord = "Java";

    @FindBy(css = "input[name='q']")
    private WebElement searchInput;
    @FindBy(xpath = "(id('jump-to-results')/li)[2]")
    private WebElement searchButton;

    @Step("Enter the language name:{languageName} and click the search button.")
    public String searchItem(String languageName) {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.clear();
        searchInput.sendKeys(languageName);
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
        return languageName;
    }

}