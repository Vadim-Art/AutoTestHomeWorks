package gitHubPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlogPage {
    private WebDriverWait wait;

    public BlogPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }
    @FindBy(xpath = "//h1")
    private WebElement targetPageName;

    public String getPageName() {
        wait.until(ExpectedConditions.visibilityOf(targetPageName));
        return targetPageName.getText();

    }
}

