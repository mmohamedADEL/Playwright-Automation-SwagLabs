package pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {
    private final Page page;
    public CheckoutPage(Page page) {
        this.page = page;
    }

    private final String firstNameField = "#first-name";
    private final String lastNameField = "#last-name";
    private final String postalCodeField = "#postal-code";
    private final String continueButton = "xpath=//input[@type='submit']";
    private final String cancelButton = "xpath=//a[text()='CANCEL']";
    private final String errorMessage = "xpath=//h3[@data-test='error']";


    public CheckoutPage enterFirstName(String firstName) {
        page.fill(firstNameField, firstName);
        return this;
    }
    public CheckoutPage enterLastName(String lastName) {
        page.fill(lastNameField, lastName);
        return this;
    }
    public CheckoutPage enterPostalCode(String postalCode) {
        page.fill(postalCodeField, postalCode);
        return this;
    }
    public OverviewPage clickOnContinueButton() {
        page.click(continueButton);
        return new OverviewPage(page);
    }
    public CartPage clickOnCancelButton() {
        page.click(cancelButton);
        return new CartPage(page);
    }
    public CheckoutPage fillCheckoutForm(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        return this;
    }
    public String getErrorMessage() {
        return page.locator(errorMessage).innerText();
    }
}
