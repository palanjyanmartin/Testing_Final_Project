package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static constants.iStyleSearchPageLocators.*;
import static helpers.helperMethods.*;

/**
 * Represents the page object for the iStyle search page.
 * This class contains methods to interact with the search page elements and retrieve search results.
 */
public class iStyleSearchPage extends BasePage {

    private WebDriver driver;
    private By chooseOption = By.cssSelector(chooseOption_CSS);
    private By lowToHigh = By.xpath(lowToHigh_FullPath);
    private By highToLow = By.xpath(highToLow_FullPath);

    private By resultsPage = By.cssSelector(resultsPage_CSS);

    private By buyFirst = By.cssSelector(buyButton_CSS);

    private By buySecond = By.cssSelector(buySecondItem_CSS);

    /**
     * Constructor for iStyleSearchPage.
     *
     * @param driver The WebDriver instance
     */
    public iStyleSearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Sorts the search results from low to high prices.
     *
     * @return The updated iStyleSearchPage instance
     */
    public iStyleSearchPage lowToHigh() {
        findElement(chooseOption).click();
        findElement(lowToHigh).click();
        return new iStyleSearchPage(driver);
    }

    /**
     * Sorts the search results from high to low prices.
     *
     * @return The updated iStyleSearchPage instance
     */
    public iStyleSearchPage highToLow() {
        findElement(chooseOption).click();
        findElement(highToLow).click();
        return new iStyleSearchPage(driver);
    }

    /**
     * Retrieves the list of low prices from the search results.
     *
     * @return The list of low prices
     */
    public List<Integer> getLowPrices() {
        return extractPrices(findElement(resultsPage).getText());
    }

    /**
     * Retrieves the list of high prices from the search results.
     *
     * @return The list of high prices
     */
    public List<Integer> getHighPrices() {
        return extractPrices(findElement(resultsPage).getText());
    }

    /**
     * Navigates to the result item page by clicking on the first buy button.
     *
     * @return An instance of iStyleSearchResultItemPage representing the result item page
     */
    public iStyleSearchResultItemPage navigateToResultItem() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buyFirst));
        findElement(buyFirst).click();
        return new iStyleSearchResultItemPage(driver);
    }

    /**
     * Navigates to the result item page by clicking on the second buy button.
     *
     * @return An instance of iStyleSearchResultItemPage representing the result item page
     */
    public iStyleSearchResultItemPage navigateToResultSecondItem() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buySecond));
        findElement(buySecond).click();
        return new iStyleSearchResultItemPage(driver);
    }

    /**
     * Retrieves the list of titles from the search results.
     *
     * @return The list of titles
     */
    public List<String> getTitle() {
        return extractTitles(findElement(resultsPage).getText());
    }
}
