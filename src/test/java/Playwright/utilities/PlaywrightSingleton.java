package Playwright.utilities;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;
import utilities.ConfigurationReader;

public class PlaywrightSingleton {
    private static Browser browserInstance;
    private static Playwright playwright;
    private PlaywrightSingleton() {
        // Private constructor to prevent instantiation
    }

    public static synchronized Browser getBrowserInstance() {
        if (browserInstance == null) {

            try {
                String browserType = ConfigurationReader.getProperty("browser");
                 playwright = Playwright.create();
                switch (browserType) {
                    case "chrome":
                        browserInstance = playwright.chromium().launch(
                                new BrowserType.LaunchOptions().setHeadless(false)
                        );
                        break;
                    case "firefox":
                        browserInstance = playwright.firefox().launch(
                                new BrowserType.LaunchOptions().setHeadless(false)
                        );
                        break;
                    case "webkit":
                        browserInstance = playwright.webkit().launch(
                                new BrowserType.LaunchOptions().setHeadless(false)
                        );
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid browser type");
                }
            }
            catch (PlaywrightException e) {
                e.printStackTrace();
            }
        }
        return browserInstance;
    }

    public static void closeBrowserInstance() {
        if (browserInstance != null) {
            browserInstance.close();
            browserInstance = null;
            playwright.close();
        }
    }
}
