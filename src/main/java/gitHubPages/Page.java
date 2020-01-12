package gitHubPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private WebDriverWait shortWait;
    private Actions actions;
    private JavascriptExecutor js;

    Page(PageManager pages) {
        this.driver = pages.getDriver();
        actions = new Actions(driver);
//        wait = new WebDriverWait(driver,10);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        shortWait = new WebDriverWait(driver, 3);
        shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        js = (JavascriptExecutor) driver;
    }
}
