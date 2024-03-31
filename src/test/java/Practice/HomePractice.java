package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class HomePractice {
  pages.HomePage homePage =new pages.HomePage();
   //navigating to main page validate current Link
    @Test
    public void mainPage(){
        String currentUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://practice.cydeo.com/";
        Assert.assertEquals(currentUrl,expectedUrl);
    }
    //finding all link text
    @Test
    public void linkText(){
        System.out.println("All Link Text = " + homePage.getAllLinksText());

    }
}
