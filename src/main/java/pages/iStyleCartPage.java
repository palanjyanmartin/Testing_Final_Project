package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.iStyleCartPageLocators.*;
import static helpers.helperMethods.getThePrice;

/**
 * Represents the page object for the iStyle cart page.
 * This class contains methods to interact with the cart page elements.
 */
public class iStyleCartPage extends BasePage {
    private WebDriver driver;
    private By cartButton = By.cssSelector(cartButton_CSS);
    private By amountItems = By.cssSelector(amountItems_CSS);
    private By removeItem = By.cssSelector(remove_CSS);

    private By quantityEditor = By.name(quantityEditor_NAME);
    private By updateCart = By.cssSelector(updateCart_CSS);

    private By firstItemName = By.cssSelector(firstAddedItemName_CSS);
    private By firstItemPrice = By.cssSelector(firstAddedItemPrice_CSS);
    private By secondItemName = By.cssSelector(secondAddedItemName_CSS);
    private By secondItemPrice = By.cssSelector(secondAddedItemPrice_CSS);

    private By fullPrice = By.cssSelector(fullPrice_CSS);

    /**
     * Constructor for iStyleCartPage.
     *
     * @param driver The WebDriver instance
     */
    public iStyleCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Removes a single item from the cart.
     *
     * @return The updated iStyleCartPage instance
     */
    public iStyleCartPage removeItem() {
        findElement(removeItem).click();
        return new iStyleCartPage(driver);
    }


    /**
     * Updates the cart.
     *
     * @return The updated iStyleCartPage instance
     */
    public iStyleCartPage updateCart() {
        findElement(cartButton).click();
        return new iStyleCartPage(driver);
    }

    /**
     * Gets the number of items in the cart.
     *
     * @return The number of items in the cart
     */
    public int numberOfItems() {
        return Integer.parseInt(findElement(amountItems).getText());
    }

    /**
     * Adds quantity of two to the cart.
     */
    public void addQuantityTwo() {
        WebElement selectEl = findElement(quantityEditor);
        Select select = new Select(selectEl);
        select.selectByVisibleText("2");
    }

    /**
     * Adds quantity of three to the cart.
     */
    public void addQuantityThree() {
        WebElement selectEl = findElement(quantityEditor);
        Select select = new Select(selectEl);
        select.selectByVisibleText("3");
    }

    /**
     * Confirms the editions made to the cart.
     *
     * @return The updated iStyleCartPage instance
     */
    public iStyleCartPage confirmEditions() {
        findElement(updateCart).click();
        return new iStyleCartPage(driver);
    }

    /**
     * Gets the name of the first item in the cart.
     *
     * @return The name of the first item in the cart
     */
    public String getFirstItemName() {
        return findElement(firstItemName).getText();
    }

    /**
     * Gets the name of the second item in the cart.
     *
     * @return The name of the second item in the cart
     */
    public String getSecondItemName() {
        return findElement(secondItemName).getText();
    }

    /**
     * Gets the price of the first item in the cart.
     *
     * @return The price of the first item in the cart
     */
    public String getFirstItemPrice() {
        return findElement(firstItemPrice).getText();
    }

    /**
     * Gets the price of the second item in the cart.
     *
     * @return The price of the second item in the cart
     */
    public String getSecondItemPrice() {
        return findElement(secondItemPrice).getText();
    }

    /**
     * Gets the total price of the cart.
     *
     * @return The total price of the cart
     */
    public int fullCartIncPrice() {
        return getThePrice(findElement(fullPrice).getText());
    }

    /**
     * Gets the total price of the cart.
     *
     * @return The total price of the cart
     */
    public int fullCartPrice() {
        String initial = findElement(fullPrice).getText();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.not(ExpectedConditions.textToBe(fullPrice, initial)));
        return getThePrice(findElement(fullPrice).getText());
    }
}



