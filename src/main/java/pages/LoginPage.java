package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }
    private final String usernameField = "#user-name";
    private final String passwordField = "#password";
    private final String loginButton = "#login-button";

    public LoginPage enterPassword(String password) {
        page.fill(passwordField, password);
        return this;
    }

    public LoginPage enterUsername(String username) {
        page.fill(usernameField, username);
        return this;
    }
    public HomePage clickOnLoginButton() {
        page.click(loginButton);
        return new HomePage(page);
    }
}
