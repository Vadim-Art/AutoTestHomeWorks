package helpers;

import gitHubPages.PageManager;
import managers.AppManager;

public class NavigationHelper extends PageManager {

    public NavigationHelper() {
        super(AppManager.getWebDriver());
    }

    private String loginPageUrl = System.getProperty("gitHub.login.page.url");
    private String homePageUrl = System.getProperty("gitHub.home.page.url");

    // login test
    public void goToLoginForm(){
        driver.get(loginPageUrl);
    }


    //login + go to blog link test

    public void getBlogLink() {
        gitHubPage.selectBlogLink();
    }

    //usersRepositoryCountFileTest

    public void goToUsersRepository() {
        gitHubPage.selectUsersRepository();
    }

}
