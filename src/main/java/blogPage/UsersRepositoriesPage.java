package blogPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UsersRepositoriesPage {
    private WebDriverWait wait;
    private static final String usersElementsLocator = "//tr/td[@class='content' and (not(@colspan ='3'))]";
    private static final String usersFoldersLocator = "//td[@class='content']/span/../../td/*[name()='svg' and @aria-label = 'directory']";
    private static final String usersOtherFilesLocator = "//td[@class='content']/span/../../td/*[name()='svg' and @aria-label = 'file']";

    public UsersRepositoriesPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    @FindBy(xpath = usersElementsLocator)
    private List <WebElement> usersList;

    public int getUserFiles() {
        wait.until(ExpectedConditions.visibilityOf(usersList.get(0)));
        return usersList.size();
    }

    @FindBy(xpath = usersFoldersLocator)
    private List <WebElement> usersFolderList;

    public int getUserFolder(){
        wait.until(ExpectedConditions.visibilityOf(usersFolderList.get(0)));
        return usersFolderList.size();
    }

    @FindBy(xpath = usersOtherFilesLocator)
    private List <WebElement> userFilesList;

    public int getUsersFiles(){
        wait.until(ExpectedConditions.visibilityOf(userFilesList.get(0)));
        return userFilesList.size();
    }
}
