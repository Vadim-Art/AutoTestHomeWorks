package blogPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GitHubPage {
    private WebDriverWait wait;

    public GitHubPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    @FindBy(xpath = "//li/a[@href='https://github.blog']")
    private WebElement linkToBlog;


    public void selectBlogLink(){
        wait.until(ExpectedConditions.visibilityOf(linkToBlog));
        linkToBlog.click();
    }

}
