package Practice;

import base.HomeBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AddRemovePage;
import pages.HomePage;

import java.util.List;

public class AddAndRemove extends HomeBase {


    //button name validation
    @Test(priority = 0)
    public void addAndRemove(){
        AddRemovePage addRemovePage=new AddRemovePage();
        HomePage homePage =new HomePage();
//        Driver.getDriver().get(ConfigurationReader.getProperty("homeUrl"));
        homePage.addRemove.click();
        String text = addRemovePage.addElementButton.getText();
        System.out.println("text = " + text);
      //  Assert.assertEquals(1,2);
//        Driver.getDriver().close();
    }
    //delete button displayed
    @Test(priority = 1)
    public void addAndRemoveClick(){
        AddRemovePage addRemovePage=new AddRemovePage();
        HomePage homePage =new HomePage();
//        Driver.getDriver().get(ConfigurationReader.getProperty("homeUrl"));
        homePage.addRemove.click();
        addRemovePage.addElementButton.click();
        String text = addRemovePage.deleteButton.getText();
        System.out.println("text = " + text);
        boolean displayed = addRemovePage.deleteButton.isDisplayed();
        Assert.assertTrue(displayed);
//        Driver.getDriver().close();
    }
    @Test(priority = 2)
    public void deleteClick(){
        AddRemovePage addRemovePage=new AddRemovePage();
        HomePage homePage =new HomePage();
//        Driver.getDriver().get(ConfigurationReader.getProperty("homeUrl"));
        homePage.addRemove.click();
        addRemovePage.addElementButton.click();
        String text = addRemovePage.deleteButton.getText();
        System.out.println("text = " + text);
        boolean displayed = addRemovePage.deleteButton.isDisplayed();
        Assert.assertTrue(displayed);
        addRemovePage.deleteButton.click();
        List<WebElement> button = addRemovePage.button;
        int size = button.size();
        Assert.assertEquals(1,size);
//        Driver.getDriver().close();

    }
}
