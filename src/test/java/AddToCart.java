import org.testng.annotations.Test;
import pages.*;

import static providers.iStyleDataProviders.*;
import static org.testng.Assert.*;

/**
 * Test class to verify the functionality related to adding items to the cart.
 */
public class AddToCart extends BaseTest {


    /**
     * Test #1: Ensure the successful addition of one item to the cart.
     */
    @Test
    public void testOneItemAddition() {
        // Perform a search, navigate to the SearchResultItemPage, add an item to the cart, and verify the confirmation message
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(searchTitle);
        iStyleSearchPage iStyleSearchPage = iStyleheader.searchTheResult();
        iStyleSearchResultItemPage iStyleSearchResultItemPage = iStyleSearchPage.navigateToResultItem();
        iStyleSearchResultItemPage iStyleSearchResultItemPage1 = iStyleSearchResultItemPage.addToCart();
        String n1 = iStyleSearchResultItemPage1.getItemName();
        String n2 = iStyleSearchResultItemPage1.getItemKanxikPrice();
        iStyleCartPage iStyleCartPage = iStyleSearchResultItemPage1.openCart();
        String c1 = iStyleCartPage.getFirstItemName();
        String c2 = iStyleCartPage.getFirstItemPrice();
        assertTrue(c1.contains(n1) && n2.equals(c2), "Expected added item name and price to match the cart's first item name and price.");
    }

    /**
     * Test #2: Ensure the successful addition of multiple items (two) to the cart.
     */
    @Test
    public void testMultipleItemsAddition() {
        // Perform a search, add the first item to the cart, perform another search, add the second item to the cart, and verify the total item count
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(searchTitle);
        iStyleSearchPage iStyleSearchPage = iStyleheader.searchTheResult();
        iStyleSearchResultItemPage iStyleSearchResultItemPage = iStyleSearchPage.navigateToResultItem();
        iStyleSearchResultItemPage iStyleSearchResultItemPage1 = iStyleSearchResultItemPage.addToCart();
        String n1 = iStyleSearchResultItemPage1.getItemName();
        String p1 = iStyleSearchResultItemPage1.getItemKanxikPrice();

        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(searchTitle);
        iStyleSearchPage iStyleSearchPage1 = iStyleheader.searchTheResult();
        iStyleSearchResultItemPage iStyleSearchResultItemPage2 = iStyleSearchPage1.navigateToResultSecondItem();
        iStyleSearchResultItemPage iStyleSearchResultItemPage3 = iStyleSearchResultItemPage2.addToCart();
        String n2 = iStyleSearchResultItemPage3.getItemName();
        String p2 = iStyleSearchResultItemPage3.getSecondItemPrice();
        iStyleCartPage iStyleCartPage = iStyleSearchResultItemPage3.openCart();
        String c1n1 = iStyleCartPage.getFirstItemName();
        String c1p1 = iStyleCartPage.getFirstItemPrice();
        String c2n2 = iStyleCartPage.getSecondItemName();
        String c2p2 = iStyleCartPage.getSecondItemPrice();
        assertTrue(c1n1.contains(n1) && c1p1.equals(p1) && c2n2.contains(n2) && c2p2.equals(p2), "Expected both added items to be present in the cart with correct names and prices.");
    }
}
