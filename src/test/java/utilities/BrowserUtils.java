package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    /*
    This method will accept int (in seconds) and execute Thread.sleep
    for given duration
     */
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle) {

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {

            driver.switchTo().window(each);

            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        //5. Assert:Title contains “expectedInTitle”
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /*
    This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(WebDriver driver, String expectedTitle) {

        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }

    /*
    Creating a utility method for ExplicitWait, so we don't have to repeat the lines
     */
    public static void waitForInvisibilityOf(WebElement webElement) {
        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }
    public static void waitForVisibilityOf(WebElement webElement) {
        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public static void scrollToElement( ) {
        // Cast WebDriver to JavascriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        // Execute JavaScript to scroll until the element is in view
        jsExecutor.executeScript("window.scrollBy(0,500)");
    }
    public static void scrollToElement(WebElement element) {
        // Cast WebDriver to JavascriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        // Execute JavaScript to scroll until the element is in view
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void scrollToElement( int measure) {
        // Cast WebDriver to JavascriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        // Execute JavaScript to scroll until the element is in view
        jsExecutor.executeScript("window.scrollBy(0,"+measure+")");
    }
}
