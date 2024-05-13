package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.iStyleHeaderLocators.*;

/**
 * Represents the page object for the iStyle header.
 * This class contains methods to interact with the header elements.
 */
public class iStyleHeader extends BasePage {
    private WebDriver driver;
    private By search = By.cssSelector(search_CSS);
    private By searchButton = By.cssSelector(search_Button_CSS);

    /**
     * Constructor for iStyleHeader.
     *
     * @param driver The WebDriver instance
     */
    public iStyleHeader(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on the search input field.
     */
    public void clickOnSearch() {
        findElement(search).click();
    }

    /**
     * Sets the search input field with the specified title.
     *
     * @param title The title to search for
     */
    public void setSearchResult(String title) {
        findElement(search).sendKeys(title);
    }

    /**
     * Initiates a search based on the entered search criteria.
     *
     * @return An instance of iStyleSearchPage representing the search results page
     */
    public iStyleSearchPage searchTheResult() {
        findElement(searchButton).click();
        return new iStyleSearchPage(driver);
    }

    /**
     * Initiates a search for a single item based on the entered search criteria.
     *
     * @return An instance of iStyleSearchResultItemPage representing the single item search result page
     */
    public iStyleSearchResultItemPage searchTheSingleItemResult() {
        findElement(searchButton).click();
        return new iStyleSearchResultItemPage(driver);
    }
}
