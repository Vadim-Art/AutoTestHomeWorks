package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver,this);
        this.wait = wait;
    }

    @FindBy (xpath = "//div[@class = 'auth-form-body mt-3']")
    private WebElement loginForm;

    @FindBy (xpath = "//input[@id='login_field']")
    private WebElement userNameInput;

    @FindBy (xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy (xpath = "//input [@type = 'submit']")
    private WebElement signInButton;

    public void userLogin(String userName, String password){
        wait.until(ExpectedConditions.visibilityOf(loginForm));
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        signInButton.click();

    }

}
