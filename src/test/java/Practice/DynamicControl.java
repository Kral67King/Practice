package Practice;

import base.HomeBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.DynamicControlPage;
import pages.HomePage;
import utilities.BrowserUtils;

public class DynamicControl extends HomeBase {

    HomePage homePage=new HomePage();
    DynamicControlPage dynamicControlPage=new DynamicControlPage();
    @Test
    public void RemoveButton(){
        homePage.dynamicControl.click();
        dynamicControlPage.removeButton.click();
        BrowserUtils.waitForVisibilityOf(dynamicControlPage.addButton);
        String message = dynamicControlPage.message.getText();
        Assert.assertEquals(message,"It's gone!");
        BrowserUtils.sleep(2);
        dynamicControlPage.addButton.click();
        BrowserUtils.sleep(2);
        String messageBack = dynamicControlPage.messageBack.getText();
        Assert.assertEquals(messageBack,"It's back!");
        BrowserUtils.sleep(2);
        dynamicControlPage.checkBox.click();
        Assert.assertTrue(dynamicControlPage.checkBox.isSelected());
        dynamicControlPage.enableButton.click();
        BrowserUtils.waitForVisibilityOf(dynamicControlPage.disableButton);
        String messageEnabled = dynamicControlPage.message.getText();
        Assert.assertEquals(messageEnabled,"It's enabled!");
        BrowserUtils.sleep(2);
        dynamicControlPage.disableButton.click();
        BrowserUtils.waitForVisibilityOf(dynamicControlPage.enableButton);
        String messageDisabled = dynamicControlPage.message.getText();
        Assert.assertEquals(messageDisabled,"It's disabled!");
        BrowserUtils.sleep(2);
    }
}
