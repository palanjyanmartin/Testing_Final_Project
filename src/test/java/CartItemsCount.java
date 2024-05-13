import org.testng.annotations.Test;
import pages.*;

import static providers.iStyleDataProviders.*;
import static org.testng.Assert.*;

/**
 * Test class to verify the functionality related to the Cart and items count.
 */
public class CartItemsCount extends BaseTest {

    /**
     * Test #1: Ensure the Cart is empty by default at the beginning.
     */
    @Test
    public void testCartDefaultAmount() {
        // Given a search result, when navigating to the item page, then the cart should be empty by default.
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(searchTitle);
        iStyleSearchPage iStyleSearchPage = iStyleheader.searchTheResult();
        iStyleSearchResultItemPage iStyleSearchResultItemPage = iStyleSearchPage.navigateToResultItem();
        assertEquals(iStyleSearchResultItemPage.numberOfItems(), 0, "Expected: 0");
    }

    /**
     * Test #2: Ensure that the item count in the cart is incremented by one after adding an item.
     */
    @Test
    public void testOneItemCountIncrementation() {
        // Given a search result, when adding an item to the cart, then the total item count in the cart should increase by one.
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(searchTitle);
        iStyleSearchPage iStyleSearchPage = iStyleheader.searchTheResult();
        iStyleSearchResultItemPage iStyleSearchResultItemPage = iStyleSearchPage.navigateToResultItem();
        iStyleSearchResultItemPage.addToCart();
        assertEquals(iStyleSearchResultItemPage.numberOfItems(), 1, "Expected: 1");
    }

    /**
     * Test #3: Ensure the addition of two items to the cart results in items count menu turning from zero to two.
     */
    @Test
    public void testMultipleItemsAddition() {
        // Given a search result, when adding two items to the cart, then the total item count in the cart should be two.
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(searchTitle);
        iStyleSearchPage iStyleSearchPage = iStyleheader.searchTheResult();
        iStyleSearchResultItemPage iStyleSearchResultItemPage = iStyleSearchPage.navigateToResultItem();
        iStyleSearchResultItemPage.addToCart();
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(searchTitle);
        iStyleSearchPage iStyleSearchPage1 = iStyleheader.searchTheResult();
        iStyleSearchResultItemPage iStyleSearchResultItemPage1 = iStyleSearchPage1.navigateToResultSecondItem();
        iStyleSearchResultItemPage1.addToCart();
        assertEquals(iStyleSearchResultItemPage.numberOfItems(), 2, "Expected: 2");
    }

    /**
     * Test #4: Remove the first item from the cart list.
     */
    @Test
    public void testDeletionOfFirstItem() {
        // Given a search result with two items in the cart, when removing the first item, then the total item count in the cart should decrease.
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(searchTitle);
        iStyleSearchPage iStyleSearchPage = iStyleheader.searchTheResult();
        iStyleSearchResultItemPage iStyleSearchResultItemPage = iStyleSearchPage.navigateToResultItem();
        iStyleSearchResultItemPage.addToCart();
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(searchTitle);
        iStyleSearchPage iStyleSearchPage1 = iStyleheader.searchTheResult();
        iStyleSearchResultItemPage iStyleSearchResultItemPage1 = iStyleSearchPage1.navigateToResultSecondItem();
        iStyleSearchResultItemPage1.addToCart();
        iStyleCartPage iStyleCartPage = iStyleSearchResultItemPage1.openCart();
        int numberOfItemsBefore = iStyleCartPage.numberOfItems();
        iStyleCartPage iStyleCartPage1 = iStyleCartPage.removeItem();
        iStyleCartPage1.updateCart();
        int numberOfItemsAfter = iStyleCartPage1.numberOfItems();
        assertTrue(numberOfItemsBefore > numberOfItemsAfter, "Expected: Before count to be more than Afters");
    }


    /**
     * Test #6: Add a quantity to an item in the cart and check whether the items count menu is being incremented.
     */
    @Test
    public void testAddingQuantity() {
        // Given a search result with one item in the cart, when increasing the quantity of the item, then the total item count in the cart should increase.
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(searchTitle);
        iStyleSearchPage iStyleSearchPage = iStyleheader.searchTheResult();
        iStyleSearchResultItemPage iStyleSearchResultItemPage = iStyleSearchPage.navigateToResultItem();
        iStyleSearchResultItemPage.addToCart();
        int numberOfItemsBefore = iStyleSearchResultItemPage.numberOfItems();
        iStyleCartPage iStyleCartPage = iStyleSearchResultItemPage.openCart();
        int beforePrice = iStyleCartPage.fullCartIncPrice();
        iStyleCartPage.addQuantityTwo();
        iStyleCartPage.confirmEditions();
        iStyleCartPage iStyleCartPage1 = iStyleCartPage.updateCart();
        int currentPrice = iStyleCartPage1.fullCartIncPrice();
        int numberOfItemsAfter = iStyleCartPage1.numberOfItems();
        assertTrue(numberOfItemsBefore < numberOfItemsAfter, "Expected: Current number of items should be greater");
        assertTrue(beforePrice < currentPrice, "Expected: Before price should be less than current one");
    }

    /**
     * Test #7: Remove one item from the cart and check if the total price is reduced.
     */
    @Test
    public void testDecreasingQuantity() {
        // Given a search result with one item in the cart, when decreasing the quantity of the item, then the total price in the cart should decrease.
        iStyleheader.clickOnSearch();
        iStyleheader.setSearchResult(searchTitle);
        iStyleSearchPage iStyleSearchPage = iStyleheader.searchTheResult();
        iStyleSearchResultItemPage iStyleSearchResultItemPage = iStyleSearchPage.navigateToResultItem();
        iStyleSearchResultItemPage.addToCart();
        iStyleCartPage iStyleCartPage = iStyleSearchResultItemPage.openCart();
        iStyleCartPage.addQuantityThree();
        iStyleCartPage iStyleCartPage1 = iStyleCartPage.confirmEditions();
        int beforePrice = iStyleCartPage1.fullCartPrice();
        iStyleCartPage iStyleCartPage2 = iStyleCartPage1.updateCart();
        iStyleCartPage2.addQuantityTwo();
        iStyleCartPage iStyleCartPage3 = iStyleCartPage2.confirmEditions();
        int currentPrice = iStyleCartPage3.fullCartPrice();
        assertTrue(beforePrice > currentPrice, "Expected: Before price should be greater than current one ");
    }
}
