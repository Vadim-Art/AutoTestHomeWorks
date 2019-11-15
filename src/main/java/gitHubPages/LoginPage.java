package gitHubPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Page {
    private String userName = System.getProperty("user.name");
    private String password = System.getProperty("user.password");
    @FindBy(xpath = "//div[@class = 'auth-form-body mt-3']")
    private WebElement loginForm;
    @FindBy(xpath = "//input[@id='login_field']")
    private WebElement userNameInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input [@type = 'submit']")
    private WebElement signInButton;

    public LoginPage(PageManager pages) {
        super(pages);
    }

    public void userLogin() {
        wait.until(ExpectedConditions.visibilityOf(loginForm));
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

}
