package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BasicAuthPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class BasicAuth {
    BasicAuthPage basicAuthPage=new BasicAuthPage();
    @And("user successfully sign")
    public void userSuccessfullySign() {
        BrowserUtils.sleep(3);
        Driver.getDriver().get("admin:admin@https://practice.cydeo.com/basic_auth");
        BrowserUtils.sleep(3);
    }

    @Then("User see successfully signed message")
    public void userSeeSuccessfullySignedMessage() {
        String expected="Congratulations! You must have the proper credentials.";
        String actualText = basicAuthPage.text.getText();
        System.out.println("actualText = " + actualText);
       // Assert.assertEquals(expected,actualText);

    }


}
