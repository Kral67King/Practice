package stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.GooglePage;
import utilities.BrowserUtils;
import utilities.Driver;

import javax.swing.*;

public class Google {
    GooglePage googlePage=new GooglePage();
    @Given("User navigate to Google page and right click image")
    public void userNavigateToGooglePageAndRightClickImage() {
        Driver.getDriver().get("https://www.google.com/");
        Actions actions=new Actions(Driver.getDriver());
        actions.contextClick(googlePage.images).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
        BrowserUtils.sleep(3);
    }
}
