package gitHubPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class UsersRepositoriesPage extends Page {
    private static final String usersElementsLocator = "//tr/td[@class='content' and (not(@colspan ='3'))]";
    private static final String usersFoldersLocator = "//td[@class='content']/span/../../td/*[name()='svg' and @aria-label = 'directory']";
    private static final String usersOtherFilesLocator = "//td[@class='content']/span/../../td/*[name()='svg' and @aria-label = 'file']";
    private static final String fileNameLocator = "//a[contains(text(),'README.md')]";
    @FindBy(xpath = usersElementsLocator)
    private List<WebElement> usersList;
    @FindBy(xpath = usersFoldersLocator)
    private List<WebElement> usersFolderList;
    @FindBy(xpath = usersOtherFilesLocator)
    private List<WebElement> userFilesList;
    @FindBy(xpath = fileNameLocator)
    private WebElement file;
    @FindBy(css = "a[title ='src']")
    private WebElement folderName;
    @FindBy(css = "a[title ='.gitignore']")
    private WebElement ignoreFileName;
    @FindBy(css = "a[title ='pom.xml']")
    private WebElement pomFileName;

    UsersRepositoriesPage(PageManager pages) {
        super(pages);
    }

    public int getUserFiles() {
        wait.until(ExpectedConditions.visibilityOf(usersList.get(0)));
        return usersList.size();
    }

    public int getUserFolder() {
        wait.until(ExpectedConditions.visibilityOf(usersFolderList.get(0)));
        return usersFolderList.size();
    }

    public int getUsersFiles() {
        wait.until(ExpectedConditions.visibilityOf(userFilesList.get(0)));
        return userFilesList.size();
    }

    public String getFileName() {
        wait.until(ExpectedConditions.visibilityOf(file));
        return file.getText();
    }

    public String getFolderName() {
        wait.until(ExpectedConditions.visibilityOf(folderName));
        return folderName.getText();
    }

    public String getIgnoreFileName() {
        wait.until(ExpectedConditions.visibilityOf(ignoreFileName));
        return ignoreFileName.getText();
    }

    public String getPomFileName() {
        wait.until(ExpectedConditions.visibilityOf(pomFileName));
        return pomFileName.getText();
    }
}
