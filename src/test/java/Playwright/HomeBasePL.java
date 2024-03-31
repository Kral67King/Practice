package Playwright;

import Playwright.utilities.PlaywrightSingleton;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

public class HomeBasePL {
protected Page page;

    @BeforeMethod
    public  void launch(){
        Browser browser = PlaywrightSingleton.getBrowserInstance();
        this.page=browser.newPage();
        this.page.setViewportSize(1920, 1080);
        this.page.navigate(ConfigurationReader.getProperty("homeUrl"));
        BrowserUtils.sleep(2);
    }
    @AfterMethod
    public void close(){
        PlaywrightSingleton.closeBrowserInstance();
    }
}
