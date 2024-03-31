package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Practice {
    HomePage homePage =new HomePage();
    @Given("User navigate to HomePage Page")
    public void userNavigateToHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("homeUrl"));
    }

    @And("user validate title")
    public void userValidateTitle() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle="Practice";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @When("User click {string} validate {string}")
    public void userClickValidate(String link, String title) {
        String actualTitle = homePage.getTitle(link);
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals(title, actualTitle);

    }

    @When("User move to link at the bottom")
    public void userMoveToLinkAtTheBottom() {
        homePage.moveToLink();
    }

    @And("user validate link text {string}")
    public void userValidateLinkText(String linkText) {
        String actualText = homePage.getTextBottom();
        Assert.assertEquals(linkText,actualText);
    }

    @When("user move to Add Remove Page")
    public void userMoveToAddRemovePage() {
        homePage.clickAddRemove();
    }


    @When("user click Basic Auth link")
    public void userClickBasicAuthLink() {
        homePage.clickBasicAuth();
    }

    @When("User click Broken Images Page")
    public void userClickBrokenImagesPage() {
        homePage.brokenLinkClick();

    }

    @When("user click checkBox link")
    public void userClickCheckBoxLink() {
        homePage.checkBoxClick();
    }


    @When("user click frame")
    public void userClickFrame() {
        homePage.frame.click();
    }

    @When("user click Dropdown Menu")
    public void userClickDropdownMenu() {
        homePage.dropdown.click();
    }
}
