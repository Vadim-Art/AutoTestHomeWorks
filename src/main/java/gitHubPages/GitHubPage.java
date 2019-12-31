package gitHubPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GitHubPage extends Page {
    private String actualUsername;

    private String searchRepo = "AutoTestHomeWorks";
    @FindBy(xpath = "//li/a[@href='https://github.blog']")
    private WebElement linkToBlog;
    @FindBy(xpath = "//li/div[@class= 'width-full text-bold']")
    private WebElement linkToRepository;
    @FindBy(xpath = "//summary [contains(@aria-label, 'View profile')]")
    private WebElement dropdown;
    @FindBy(xpath = "//details-menu [contains (@class,'mt-2')]")
    private WebElement visibleDropdown;
    @FindBy(xpath = "//strong [contains(., 'test')]")
    private WebElement targetName;
    @FindBy(css = ".details-overlay .Header-link[aria-label*='Create new…']")
    private WebElement dropdownCreate;
    @FindBy(xpath = "//a[contains(text(),'New repository')]")
    private WebElement newRepositoryLink;
    @FindBy(css = ".form-control.header-search-input")
    private WebElement searchInput;
    @FindBy(xpath = "(id('jump-to-results')/li)[2]")
    private WebElement searchButton;

    GitHubPage(PageManager pages) {
        super(pages);
    }

    public void selectBlogLink() {
        wait.until(ExpectedConditions.visibilityOf(linkToBlog));
        linkToBlog.click();
    }

    public void selectUsersRepository() {
        wait.until(ExpectedConditions.visibilityOf(linkToRepository));
        linkToRepository.click();
    }

    public void selectDropDown() {
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        dropdown.click();
    }

    public String getUserNameFromDropDown() {
        wait.until(ExpectedConditions.visibilityOf(visibleDropdown));
        return targetName.getText();
    }

    public void openDropdownCreate() {
        wait.until(ExpectedConditions.visibilityOf(dropdownCreate));
        dropdownCreate.click();
    }

    public void selectDropdownItem() {
        wait.until(ExpectedConditions.visibilityOf(newRepositoryLink));
        newRepositoryLink.click();
    }

    public void searchItem() {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.clear();
        searchInput.sendKeys(searchRepo);
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }


}
