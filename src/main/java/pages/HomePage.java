package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.LogUtility;
import utilities.Utility;

import java.util.List;
import java.util.Set;

public class HomePage {
    private final Page page;
    public HomePage(Page page) {
        this.page = page;
    }
    private final String AddToCartButtonGeneral = "button.btn_primary";
    private final String cartLink = ".shopping_cart_link";
    private final String cartItemCount = ".shopping_cart_badge";
    private final String removeButton = "button.btn_secondary";
    private final String PricesProductOfSelectedProducts = "xpath=//button[text()='REMOVE']/preceding-sibling::div[@class='inventory_item_price']";
    private Locator selectedProducts;

    public static  float totalPrice ;
    public HomePage addAllProductsToCart() {
        Locator allProducts = page.locator(AddToCartButtonGeneral);
        int numberOfProducts = allProducts.count();
        for (int i = 0; i < numberOfProducts; i++) {
            allProducts.nth(i).click();
        }
        return this;
    }
    public String getNumberOfItemsInCart() {
        return Utility.getTextFromElement(page, cartItemCount);

    }
    public String getNumberOfSelectedProducts() {
        selectedProducts = page.locator(removeButton);
        int numberOfSelectedProducts = selectedProducts.count();
        return String.valueOf(numberOfSelectedProducts);
    }
    public boolean compareSelectedProductsAndCartProducts() {
        return getNumberOfItemsInCart().equals(getNumberOfSelectedProducts());
    }
    public HomePage addRandomProductToCart(int numberOfProductsToSelect, int numberOfAllProducts) {
        Set<Integer> uniqueRandomNumbers = Utility.generateUniqueRandomNumbers(numberOfProductsToSelect, numberOfAllProducts);
        for (int randomNumber : uniqueRandomNumbers) {
            Locator buttons = page.locator(AddToCartButtonGeneral);
            if (randomNumber >= 0 && randomNumber < buttons.count()) {
                buttons.nth(randomNumber).click();
                LogUtility.info("Random product added to cart: " + randomNumber);
            } else {
                LogUtility.warn("Random number out of bounds: " + randomNumber);
            }
        }
        return this;
    }

    public CartPage clickOnCartLink() {
        Utility.clickOnElement(page, cartLink);
        LogUtility.info("Clicked on cart link");
        return new CartPage(page);
    }

    public String getTotalPriceOfSelectedProducts() {
        List<Locator> prices = page.locator(PricesProductOfSelectedProducts).all();
        totalPrice = 0;
        for (Locator price : prices) {
            String priceText = price.innerText();
            float priceValue = Float.parseFloat(priceText.replace("$", ""));
            totalPrice += priceValue;
        }
        LogUtility.info("Total Price " + totalPrice);
        return String.valueOf(totalPrice);
    }

}
