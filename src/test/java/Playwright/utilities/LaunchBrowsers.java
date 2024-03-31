package Playwright.utilities;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

public class LaunchBrowsers  {

    public static void main(String[] args) {
     //   launchBrowser("chromium");
       // Playwright playwright = Playwright.create();
        Browser browser = PlaywrightSingleton.getBrowserInstance();
        Page page=browser.newPage();
        page.setViewportSize(1920, 1080);
        page.navigate("https://practice.cydeo.com/");
        BrowserUtils.sleep(2);
        System.out.println("Title of the page  = " + page.title());
        PlaywrightSingleton.closeBrowserInstance();
    }
    @Test
    public  void launch(){
        Browser browser = PlaywrightSingleton.getBrowserInstance();
        Page page=browser.newPage();
        page.setViewportSize(1920, 1080);
        page.navigate(ConfigurationReader.getProperty("homeUrl"));
        BrowserUtils.sleep(2);
        System.out.println("Title of the page  = " + page.title());
        PlaywrightSingleton.closeBrowserInstance();
    }
}
