package Web_Tests;
import Pages.SearchResultWikiPage;
import Pages.WikiSearchPage;
import base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiSearchTest extends TestBase {
    WikiSearchPage wikiSearchPage;
    SearchResultWikiPage searchResultWikiPage;
    public static final String SEARCH_VALUE = "Selenium";


    @Test
    public void verifyAllBrokenLinksPresentOnPageTest() {
        wikiSearchPage = PageFactory.initElements(driver, WikiSearchPage.class);
        wikiSearchPage.verifyLinks();
    }

    @Test
    public void searchWithSecondarySearchOptionTests() {
        wikiSearchPage = PageFactory.initElements(driver, WikiSearchPage.class);
        wikiSearchPage.enterValueIntoSecondarySearchField(SEARCH_VALUE);
        searchResultWikiPage = wikiSearchPage.clickOnSecondarySearchButton();
        Assert.assertEquals(searchResultWikiPage.getFirstHeading(),SEARCH_VALUE, "Searched value does not match with displayed value");
    }
}
