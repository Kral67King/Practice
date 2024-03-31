package Practice;

import base.HomeBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IframePage;
import utilities.BrowserUtils;
import utilities.Driver;

public class Iframe extends HomeBase {
    HomePage homePage=new HomePage();
    IframePage iframePage=new IframePage();
    @Test
    public void iframe(){
        homePage.frames.click();
        iframePage.nestedFrame.click();
        Driver.getDriver().switchTo().frame(iframePage.bottomFrame);
        System.out.println("bottom text is = " + iframePage.text.getText());
        Driver.getDriver().switchTo().parentFrame();
        BrowserUtils.sleep(2);
        Driver.getDriver().switchTo().frame(iframePage.topFrame);
        Driver.getDriver().switchTo().frame(iframePage.middleFrame);
        System.out.println("middle text is = " + iframePage.text.getText());
        BrowserUtils.sleep(2);
        Driver.getDriver().switchTo().parentFrame();
        Driver.getDriver().switchTo().frame(iframePage.leftFrame);
        System.out.println("left text is = " + iframePage.text.getText());
        BrowserUtils.sleep(2);
        Driver.getDriver().switchTo().parentFrame();
        Driver.getDriver().switchTo().frame(iframePage.rightFrame);
        System.out.println("right text is = " + iframePage.text.getText());
        BrowserUtils.sleep(2);

    }
}
