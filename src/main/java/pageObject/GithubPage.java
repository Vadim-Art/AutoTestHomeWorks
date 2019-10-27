package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GithubPage {
    private WebDriverWait wait;
    private String actualUsername;

    public GithubPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    @FindBy (xpath = "//summary [contains(@aria-label, 'View profile')]")
    private WebElement dropdown;

    @FindBy (xpath = "//details-menu [contains (@class,'mt-2')]")
    private WebElement visibleDropdown;

    @FindBy(xpath = "//strong [contains(., 'test')]")
    private WebElement targetName;

    public void selectDropDown(){
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        dropdown.click();
    }

    public String getUserNameFromDropDown(){
        wait.until(ExpectedConditions.visibilityOf(visibleDropdown));
        actualUsername = targetName.getText();
        return actualUsername;
    }
}
