package stepdefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AddRemovePage;

import java.util.List;

public class AddElement {
    AddRemovePage addRemovePage=new AddRemovePage();
    @And("User click Add Element Button")
    public void userClickAddElementButton() {
        addRemovePage.addElementButton.click();
    }

    @Then("User able to see Delete button")
    public void userAbleToSeeDeleteButton() {
        addRemovePage.deleteButton.isDisplayed();
    }

    @When("User click delete button button is remove")
    public void userClickDeleteButtonButtonIsRemove() {
        addRemovePage.deleteButton.click();
        List<WebElement> button = addRemovePage.button;
       Assert.assertEquals(1, button.size());


    }


}
