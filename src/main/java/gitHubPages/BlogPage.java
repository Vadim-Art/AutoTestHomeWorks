package gitHubPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlogPage extends Page {
    @FindBy(xpath = "//h1")
    private WebElement targetPageName;


    BlogPage(PageManager pages) {
        super(pages);
    }

    public String getPageName() {
       wait.until(ExpectedConditions.visibilityOf(targetPageName));
        return targetPageName.getText();

    }
}

