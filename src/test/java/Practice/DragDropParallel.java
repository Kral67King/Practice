package Practice;

import base.HomeBase;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DragDropCirclePage;
import pages.DragDropPage;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class DragDropParallel extends HomeBase {
    @Test
    public void circleMove(){
        HomePage homePage=new HomePage();
        DragDropCirclePage dragDropCirclePage=new DragDropCirclePage();
        //Driver.getDriver().get(ConfigurationReader.getProperty("homeUrl"));
        homePage.dragAndDropCircle.click();
        Actions actions=new Actions(Driver.getDriver());
        actions.dragAndDrop(dragDropCirclePage.smallCircle, dragDropCirclePage.bigCircle)
                .pause(2000)
                .build()
                .perform();
       // Driver.getDriver().close();
    }
    @Test
    public void dragDrop(){
        HomePage homePage=new HomePage();
        DragDropPage dragDropPage=new DragDropPage();
        //Driver.getDriver().get(ConfigurationReader.getProperty("homeUrl"));
        homePage.dragAndDrop.click();
        Actions action=new Actions(Driver.getDriver());
        action.clickAndHold(dragDropPage.squareA)
                .pause(2000)
                .moveToElement(dragDropPage.squareB)
                .pause(2000)
                .release()
                .perform();
        BrowserUtils.sleep(2);
        action.dragAndDrop(dragDropPage.squareB, dragDropPage.squareA)
                .build()
                .perform();
        BrowserUtils.sleep(2);
       // Driver.getDriver().close();
    }
}
