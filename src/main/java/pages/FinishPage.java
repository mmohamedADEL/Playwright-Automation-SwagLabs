package pages;

import com.microsoft.playwright.Page;
import utilities.LogUtility;
import utilities.Utility;

public class FinishPage {
    Page page;
    public FinishPage(Page page) {
        this.page = page;
    }
    private final String confirmationMessage = ".complete-header";

    public String getConfirmationMessage() {
        String message = page.locator(confirmationMessage).innerText();
        LogUtility.info("Confirmation message: " + message);
        return message;
    }

}
