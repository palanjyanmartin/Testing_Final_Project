import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

import static constants.iStyleSearchResultItemLocators.addToCart_CSS;
import static providers.iStyleDataProviders.*;
import static constants.iStyleSearchPageLocators.*;
import static org.testng.Assert.*;

/**
 * Contains test cases related to sorting search results by price on the iStyle website.
 */
public class ResultsSortingByPrice extends BaseTest {


    /**
     * Test to verify behavior when the search results are empty.
     */
    @Test
    public void testEmptyResults() {
        // Perform a search with invalid input and verify the presence of the expected message indicating no search results
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(invalidTitle);
        iStyleSearchPage iStyleSearchPage = iStyleheader.searchTheResult();
        assertTrue(iStyleSearchPage.findElement(By.cssSelector(invalidSearchAssert_CSS)).isDisplayed());
    }

    /**
     * Test to verify behavior when only a single item is returned in the search results.
     */
    @Test
    public void testSingleItem() {
        // Perform a search and verify that the system navigates directly to the item page when only one item is found
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(singleItem);
        iStyleSearchResultItemPage iStyleSearchResultItemPage = iStyleheader.searchTheSingleItemResult();
        assertTrue(iStyleSearchResultItemPage.findElement(By.cssSelector(addToCart_CSS)).isDisplayed(),"Expected: Add To Cart Button is available");

    }

    /**
     * Test to verify sorting functionality from low to high for multiple search results.
     */
    @Test
    public void multipleItemsLowToHigh() {
        // Perform a search, sort the search results from low to high, and verify the correctness of the sorting order
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(searchTitle);
        iStyleSearchPage iStyleSearchPage = iStyleheader.searchTheResult();
        iStyleSearchPage.lowToHigh();
        List<Integer> list = iStyleSearchPage.getLowPrices();
        for (int i = 0; i < list.size() - 1; i++) {
            int currentPrice = list.get(i);
            int nextPrice = list.get(i + 1);
            assertTrue(currentPrice <= nextPrice, "Expected: Prices are sorted correctly");
        }
    }

    /**
     * Test to verify sorting functionality from high to low for multiple search results.
     * Note: Found a bug in the website - the price 779,000 comes after 729,000.
     */
    @Test
    public void multipleItemsHighToLow() {
        // Perform a search, sort the search results from high to low, and verify the correctness of the sorting order
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(searchTitle);
        iStyleSearchPage iStyleSearchPage = iStyleheader.searchTheResult();
        iStyleSearchPage.highToLow();
        List<Integer> list = iStyleSearchPage.getHighPrices();
        for (int i = 0; i < list.size() - 1; i++) {
            int currentPrice = list.get(i);
            int nextPrice = list.get(i + 1);
            assertTrue(currentPrice >= nextPrice, "Expected: Prices are sorted correctly");
        }
    }
}
