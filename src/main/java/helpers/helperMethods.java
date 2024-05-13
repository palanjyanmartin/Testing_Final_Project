package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains helper methods for extracting information from text.
 */
public class helperMethods {

    /**
     * Extracts prices from the given text.
     *
     * @param text The text to search for prices
     * @return A list of extracted prices
     */
    public static List<Integer> extractPrices(String text) {
        List<Integer> prices = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d+(\\.\\d{3})+(\\.\\d+)?)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String match = matcher.group(0).replaceAll("\\.", ""); // Remove periods
            int price = Integer.parseInt(match);
            prices.add(price);
        }
        return prices;
    }

    /**
     * Extracts titles from the given text.
     *
     * @param text The text to search for titles
     * @return A list of extracted titles
     */
    public static List<String> extractTitles(String text) {
        List<String> titles = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9\\s(),.\"”\\-]+(?=\\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            titles.add(matcher.group().trim());
        }

        return titles;
    }

    /**
     * Extracts the numeric price value from a price string.
     *
     * @param price The price string
     * @return The numeric price value
     */
    public static int getThePrice(String price) {
        String numericValueStr = price.replaceAll("[^0-9]", "");
        return Integer.parseInt(numericValueStr);
    }
}
