package gitHubPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreatingNewRepositoryPage extends Page {

    private String repositoryName = "test-repo4";
    private String repositoryDescription = "just for test purpose";
    @FindBy(css = ".new-repo-container #new_repository")
    private WebElement createForm;
    @FindBy(css = "#repository_name[name='repository[name]']")
    private WebElement repositoryNameInput;
    @FindBy(css = "#repository_description[name='repository[description]']")
    private WebElement repositoryDescriptionInput;
    @FindBy(css = "#repository_auto_init[type='checkbox']")
    private WebElement checkbox;
    @FindBy(xpath = "//button[contains(text(),'Create repository')]")
    private WebElement createButton;

    CreatingNewRepositoryPage(PageManager pages) {
        super(pages);
    }

    public void createRepository() {
        wait.until(ExpectedConditions.visibilityOf(createForm));
        repositoryNameInput.sendKeys(repositoryName);
        repositoryDescriptionInput.sendKeys(repositoryDescription);
        checkbox.click();
        createButton.click();
    }


}
