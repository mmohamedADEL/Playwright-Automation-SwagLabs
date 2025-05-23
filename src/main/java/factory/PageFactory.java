package factory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;

import java.util.List;

public class PageFactory {

    private static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> contextThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    public static void createDriverInstance(String browserName) {
        Playwright playwright = Playwright.create();
        Browser browser = switch (browserName.toLowerCase()) {
            case "firefox" -> playwright.firefox().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
            case "edge" -> playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setArgs(List.of("--start-maximized")));
            default -> playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(List.of("--start-maximized")));
        };

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();

        // Set ThreadLocal values
        playwrightThreadLocal.set(playwright);
        browserThreadLocal.set(browser);
        contextThreadLocal.set(context);
        pageThreadLocal.set(page);
    }

    public static Page getPage() {
        Page page = pageThreadLocal.get();
        if (page == null) throw new IllegalStateException("Page is not initialized. Call createDriverInstance() first.");
        return page;
    }

    public static void navigateToUrl(String url) {
        getPage().navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.LOAD));
    }

    public static void tearDown() {
        if (pageThreadLocal.get() != null) pageThreadLocal.get().close();
        if (contextThreadLocal.get() != null) contextThreadLocal.get().close();
        if (browserThreadLocal.get() != null) browserThreadLocal.get().close();
        if (playwrightThreadLocal.get() != null) playwrightThreadLocal.get().close();

        // Remove to prevent memory leak
        pageThreadLocal.remove();
        contextThreadLocal.remove();
        browserThreadLocal.remove();
        playwrightThreadLocal.remove();
    }
}
