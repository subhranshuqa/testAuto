package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultWikiPage extends WikiBasePage{

    @FindBy(id = "firstHeading")
    private WebElement firstHeading;


    public SearchResultWikiPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstHeading() {
        getWait().until(ExpectedConditions.elementToBeClickable(firstHeading));
        return firstHeading.getText();
    }
}
