package constants;

/**
 * Contains CSS locators for elements on the iStyle search page.
 */
public class iStyleSearchPageLocators {
    public static final String chooseOption_CSS = ".woocommerce-ordering > .select2 > .selection > .select2-selection > .select2-selection__arrow";
    // I know that I am using the full path, but in this case I cannot use
    // select for dropdown menus like I do in cartPage because the accessibility is hidden from
    // the website that is why I am using full path
    public static final String lowToHigh_FullPath = "/html/body/span/span/span[2]/ul/li[3]";
    public static final String highToLow_FullPath = "/html/body/span/span/span[2]/ul/li[4]";

    public static final String buyButton_CSS = ".post-17000 > .product-info";
    public static final String buySecondItem_CSS = ".post-22326 > .product-info";
    public static final String invalidSearchAssert_CSS = ".woocommerce-info";

    public static final String resultsPage_CSS = ".two_columns_25_75 > .column2";


}
