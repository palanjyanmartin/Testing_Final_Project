package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.iStyleSearchResultItemLocators.*;

/**
 * Represents the page object for the iStyle search result item page.
 * This class contains methods to interact with the elements on the search result item page.
 */
public class iStyleSearchResultItemPage extends BasePage {
    private WebDriver driver;
    private By addToCart = By.cssSelector(addToCart_CSS);
    private By cartButton = By.cssSelector(cartButton_CSS);
    private By itemsCount = By.cssSelector(itemsCount_CSS);
    private By itemName = By.cssSelector(itemName_CSS);
    private By itemKanxikPrice = By.cssSelector(itemKanxikPrice_CSS);
    private By secondItemPrice = By.cssSelector(secondItemPrice_CSS);

    /**
     * Constructor for iStyleSearchResultItemPage.
     *
     * @param driver The WebDriver instance
     */
    public iStyleSearchResultItemPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Adds the item to the cart.
     *
     * @return The updated iStyleSearchResultItemPage instance
     */
    public iStyleSearchResultItemPage addToCart() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(addToCart));
        findElement(addToCart).click();
        return new iStyleSearchResultItemPage(driver);
    }

    /**
     * Opens the cart page.
     *
     * @return An instance of iStyleCartPage representing the cart page
     */
    public iStyleCartPage openCart() {
        findElement(cartButton).click();
        return new iStyleCartPage(driver);
    }

    /**
     * Gets the number of items.
     *
     * @return The number of items
     */
    public int numberOfItems() {
        return Integer.parseInt(findElement(itemsCount).getText());
    }

    /**
     * Gets the name of the item.
     *
     * @return The name of the item
     */
    public String getItemName() {
        return findElement(itemName).getText();
    }

    /**
     * Gets the Kanxik price of the item.
     *
     * @return The Kanxik price of the item
     */
    public String getItemKanxikPrice() {
        return findElement(itemKanxikPrice).getText();
    }

    /**
     * Gets the price of the second item.
     *
     * @return The price of the second item
     */
    public String getSecondItemPrice() {
        return findElement(secondItemPrice).getText();
    }
}
