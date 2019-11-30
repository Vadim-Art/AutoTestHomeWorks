package helpers;

import gitHubPages.PageManager;
import managers.AppManager;

public class UserHelper extends PageManager {

    public UserHelper() {
        super(AppManager.getWebDriver());
    }

    // login test
    public void loginAs() {
        loginPage.userLogin();
    }

    public void getDropdown() {
        gitHubPage.selectDropDown();
    }

    public String getUserName() {
        return gitHubPage.getUserNameFromDropDown();
    }

}
