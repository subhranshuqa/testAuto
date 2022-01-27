package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class WikiSearchPage extends WikiBasePage{

    @FindBy(id = "ooui-php-1")
    private WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='oo-ui-widget oo-ui-widget-enabled mw-advancedSearch-searchPreview']")
    private WebElement advancedSearchExpandButton;

    @FindBy(xpath = "//div[@class='oo-ui-widget oo-ui-widget-enabled mw-advancedSearch-namespacesPreview']")
    private WebElement searchInExpandButton;

    @FindBy(id = "searchInput")
    private WebElement secondarySearchInput;

    @FindBy(id = "searchButton")
    private WebElement secondarySearchButton;

    @FindBy(tagName = "a")
    public static List<WebElement> links;

    public WikiSearchPage(WebDriver driver) {
        super(driver);
    }

    public void verifyLinkActive(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()==200)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
            if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {

        }
    }

    public void verifyLinks() {

        for(int i=0;i<links.size();i++)
        {
            WebElement ele= links.get(i);
            String url=ele.getAttribute("href");
            verifyLinkActive(url);
        }
    }

    public void enterValueIntoSecondarySearchField(String value) {
        getWait().until(ExpectedConditions.elementToBeClickable(secondarySearchInput));
        secondarySearchInput.sendKeys(value);
    }

    public SearchResultWikiPage clickOnSecondarySearchButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(secondarySearchInput));
        secondarySearchInput.sendKeys(Keys.RETURN);
        return PageFactory.initElements(driver, SearchResultWikiPage.class);
    }



}
