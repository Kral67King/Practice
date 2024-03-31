package stepdefinitions;

import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.CheckBoxPage;

public class CheckBoxes {
    CheckBoxPage checkBoxPage = new CheckBoxPage();

    @And("user validate  second CheckBox is selected by default")
    public void userValidateSecondCheckBoxIsSelectedByDefault() {
        System.out.println("checkBoxPage.checkBox_2.isSelected() = " + checkBoxPage.checkBox_2.isSelected());
        Assert.assertTrue(checkBoxPage.checkBox_2.isSelected(), "validation of default check box selection");

    }

    @And("user validate  {string} is {string}")
    public void userValidateIs(String checkBox, String result) {
        if (checkBox == "CheckBox_1") {
            checkBoxPage.checkBox_1.click();
            Assert.assertEquals(result, "selected");
        }  if (checkBox == "CheckBox_2") {
            checkBoxPage.checkBox_2.click();
            Assert.assertEquals(result, "deselected");
        }
    }
}

