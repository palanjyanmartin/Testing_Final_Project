import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

import static constants.iStyleHeaderLocators.*;
import static providers.iStyleDataProviders.*;
import static constants.iStyleSearchPageAssertions.*;
import static constants.iStyleSearchPageLocators.*;
import static org.testng.Assert.*;

/**
 * Contains test cases related to searching functionality on the iStyle website.
 */
public class SearchTests extends BaseTest {

    /**
     * Test to ensure that the search bar is visible in the header.
     */
    @Test
    public void testVisibilityOfSearchBar() {
        // Verify that the search bar is displayed in the header
        assertTrue(iStyleheader.findElement(By.cssSelector(search_CSS)).isDisplayed(), "Expected the search bar to be visible in the header.");
    }

    /**
     * Test to ensure the visibility of the search button in the search bar.
     */
    @Test
    public void testFunctionalityOfSearchBar() {
        // Click on the search bar, input search text, and verify the visibility of the search button
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(searchTitle);
        assertTrue(iStyleheader.findElement(By.cssSelector(search_Button_CSS)).isDisplayed(), "Expected the search button to be visible in the search bar after entering search text.");
    }

    /**
     * Test to ensure proper handling of invalid search queries.
     */
    @Test
    public void testInvalidSearch() {
        // Perform an invalid search, navigate to the search results page, and verify the error message
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(invalidTitle);
        iStyleSearchPage iStyleSearchPage = iStyleheader.searchTheResult();
        assertEquals(invalidSearchAssertion, iStyleSearchPage.findElement(By.cssSelector(invalidSearchAssert_CSS)).getText(), "Expected error message to indicate invalid search.");
    }



    // The last test is being executed using attached testng.xml for parameterized tests
    // So, to see the results run the testng.xml file


    /**
     * Test to ensure proper handling of valid search queries.
     *
     * @param validTitle The valid search title provided as a parameter
     */
    @Test
    @Parameters("Title")
    public void testValidSearch(String validTitle) {
        // Perform a valid search, navigate to the search results page, and verify the presence of expected elements
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(validTitle);
        iStyleSearchPage iStyleSearchPage = iStyleheader.searchTheResult();
        List<String> resultList = iStyleSearchPage.getTitle();
        for (String result : resultList) {
            assertTrue(result.contains(validTitle), "Expected search results to contain the valid search title.");
        }
    }
}
