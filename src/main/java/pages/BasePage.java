package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Represents the base page class for the page objects.
 * This class contains common methods and properties used across multiple page objects.
 */
public class BasePage {
    private final WebDriver driver;

    /**
     * Constructor for BasePage.
     *
     * @param driver The WebDriver instance
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Finds and returns a web element based on the given locator.
     *
     * @param by The locator strategy
     * @return The WebElement found
     */
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }
}
