package gitHubPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {
    protected LoginPage loginPage;
    protected GitHubPage gitHubPage;
    protected BlogPage blogPage;
    protected UsersRepositoriesPage usersRepositoriesPage;
    protected CreatingNewRepositoryPage creatingNewRepositoryPage;
    protected SearchResultPage searchResultPage;
    protected WebDriver driver;

    public PageManager(WebDriver webDriver) {
        this.driver = webDriver;
        loginPage = initElements(new LoginPage(this));
        gitHubPage = initElements(new GitHubPage(this));
        blogPage = initElements(new BlogPage(this));
        usersRepositoriesPage = initElements(new UsersRepositoriesPage(this));
        creatingNewRepositoryPage = initElements(new CreatingNewRepositoryPage(this));
        searchResultPage = initElements(new SearchResultPage(this));
    }

    private <T extends Page> T initElements(T page) {
        PageFactory.initElements(driver, page);
        return page;
    }

    WebDriver getDriver() {
        return driver;
    }
}
