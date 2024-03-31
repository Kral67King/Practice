package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.DropDownPage;
import utilities.BrowserUtils;

public class DropDown {
    DropDownPage dropDownPage=new DropDownPage();
    Select dropdown;
    @Then("user click simple dropDown")
    public void userClickSimpleDropDown() {
        dropdown=new Select(dropDownPage.simpleDropDown);
    }

    @And("user select {string}")
    public void userSelect(String option) {
        switch (option){
            case "Option1":
                dropdown.selectByVisibleText( dropDownPage.optionOne.getText());
                BrowserUtils.sleep(2);
                Assert.assertTrue( dropDownPage.optionOne.isSelected());
                    break;
            case "Option2":
                dropdown.selectByVisibleText( dropDownPage.optionTwo.getText());
                BrowserUtils.sleep(2);
                Assert.assertTrue( dropDownPage.optionTwo.isSelected());
                break;
        }
    }

    @And("user select {string} yearDropdown")
    public void userSelectYearDropdown(String year) {
        Select dropdownYear=new Select(dropDownPage.year);
        dropdownYear.selectByValue(year);
        BrowserUtils.sleep(2);
    }

    @And("user select  {string} monthDropdown")
    public void userSelectMonthDropdown(String month) {
        Select dropdownMonth=new Select(dropDownPage.month);
        dropdownMonth.selectByVisibleText(month);
        BrowserUtils.sleep(2);
    }

    @Then("user select {string} dayDropdown")
    public void userSelectDayDropdown(String day) {
        Select dropdownDay=new Select(dropDownPage.day);
        dropdownDay.selectByVisibleText(day);
        BrowserUtils.sleep(2);
    }
}
