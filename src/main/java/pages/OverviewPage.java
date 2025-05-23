package pages;

import com.microsoft.playwright.Page;

public class OverviewPage {
    private final Page page;
    public OverviewPage(Page page) {
        this.page = page;
    }

    private final String finishButton = "xpath=//a[text()='FINISH']";
    private final String cancelButton = "xpath=//a[text()='CANCEL']";
    private final String subtotalPrice = ".summary_subtotal_label";
    private final String taxPrice = ".summary_tax_label";
    private final String totalPrice = ".summary_total_label";

    public FinishPage clickOnFinishButton() {
        page.locator(finishButton).click();
        return new FinishPage(page);
    }
    public HomePage clickOnCancelButton() {
        page.locator(cancelButton).click();
        return new HomePage(page);
    }
    public float getSubtotalPrice() {
        float subTotalPrice = Float.parseFloat(page.locator(subtotalPrice).innerText().replace("Item total: $", ""));
        return subTotalPrice;
    }
    public float getTaxPrice() {
        float taxPriceValue = Float.parseFloat(page.locator(taxPrice).innerText().replace("Tax: $", ""));
        return taxPriceValue;
    }
    public float getTotalPrice() {
        float totalPriceValue = Float.parseFloat(page.locator(totalPrice).innerText().replace("Total: $", ""));
        return totalPriceValue;
    }
    //compare subtotal and total price
    public boolean compareSubtotalAndTotalPrice() {
        float subtotal = getSubtotalPrice();
        float tax = getTaxPrice();
        float total = getTotalPrice();
        return (subtotal + tax) == total;
    }
}
