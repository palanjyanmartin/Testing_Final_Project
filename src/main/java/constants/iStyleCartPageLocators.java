package constants;

/**
 * Contains CSS locators for elements on the iStyle cart page.
 */
public class iStyleCartPageLocators {
    public static final String cartButton_CSS = ".header_cart";
    public static final String amountItems_CSS = ".header_cart_span";

    public static final String remove_CSS = "tbody > :nth-child(1) > .product-remove";

    public static final String quantityEditor_NAME = "cart[500772a5166f3ab7f1f542fe71e97155][qty]";

    public static final String updateCart_CSS = "[name=\"update_cart\"]";

    public static final String firstAddedItemName_CSS = ".product-name > a";

    public static final String firstAddedItemPrice_CSS = ".product-price > .woocommerce-Price-amount > bdi";

    public static final String secondAddedItemName_CSS = ":nth-child(2) > .product-name > a";

    public static final String secondAddedItemPrice_CSS = ":nth-child(2) > .product-price > .woocommerce-Price-amount > bdi";

    public static final String fullPrice_CSS = "strong > .woocommerce-Price-amount > bdi";

}

