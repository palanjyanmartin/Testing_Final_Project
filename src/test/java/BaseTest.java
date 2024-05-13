import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.iStyleHeader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import static constants.iStyleBaseURL.base_url;

/**
 * BaseTest class serves as the parent class for all test classes.
 * It initializes and terminates the WebDriver and provides common setup and teardown logic for tests.
 */
public class BaseTest {
    protected WebDriver driver;
    protected iStyleHeader iStyleheader;

    /**
     * Initializes the WebDriver before each test method.
     *
     * @throws MalformedURLException If the URL for RemoteWebDriver is malformed
     */
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        FirefoxOptions capabilities = new FirefoxOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.get(base_url);
        iStyleheader = new iStyleHeader(driver);
    }

    /**
     * Tears down the test environment after each test method.
     * Captures a screenshot if the test fails.
     *
     * @param result The result of the test
     * @throws IOException If an I/O error occurs
     */
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            // Capture screenshot on test failure
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = "failure_" + timestamp + ".png";
            FileUtils.copyFile(screenshotFile, new File("src/main/resources/screenshots" + screenshotName));
        }
        // Quit the WebDriver instance
        driver.quit();
    }
}
