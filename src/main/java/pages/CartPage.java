package pages;

import com.microsoft.playwright.Page;
import utilities.LogUtility;

public class CartPage {
    private final Page page;
    public CartPage(Page page) {
        this.page = page;
    }
    public static float totalPrice ;

    private final String checkoutButton = "xpath=//a[contains(@class,'checkout_button')]";
    private final String ContinueShopping = "xpath=//a[contains(text(), 'Continue')]";
    private final String removeButton = "xpath=//button[contains(text(), 'REMOVE')]";
    private final String pricesProductOfSelectedProducts = "xpath=//button[text()='REMOVE']/preceding-sibling::div[@class='inventory_item_price']";

    public CheckoutPage clickOnCheckoutButton() {
        page.locator(checkoutButton).click();
        LogUtility.info("Clicked on Continue Shopping button");
        return new CheckoutPage(page);
    }
    public HomePage clickOnContinueShopping() {
        page.locator(ContinueShopping).click();
        LogUtility.info("Clicked on Continue Shopping button");
        return new HomePage(page);
    }
    public String getTotalPriceOfSelectedProducts() {
        totalPrice = 0;
        for (String priceText : page.locator(pricesProductOfSelectedProducts).allInnerTexts()) {
            float priceValue = Float.parseFloat(priceText.replace("$", ""));
            totalPrice += priceValue;
        }
        LogUtility.info("Total Price " + totalPrice);
        return String.valueOf(totalPrice);
    }
}
