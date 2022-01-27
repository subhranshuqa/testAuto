package Pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WikiBasePage extends TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public WikiBasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, 20);
        actions = new Actions(driver);
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public Actions getActions() {
        return actions;
    }
}
