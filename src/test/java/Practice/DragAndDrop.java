package Practice;

import base.HomeBase;
import io.cucumber.java.bs.A;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DragDropCirclePage;
import pages.DragDropPage;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.Driver;

public class DragAndDrop extends HomeBase {
    HomePage homePage=new HomePage();
   DragDropPage dragDropPage=new DragDropPage();
   DragDropCirclePage dragDropCirclePage=new DragDropCirclePage();
    @Test
    public void circleMove(){
        homePage.dragAndDropCircle.click();
        Actions actions=new Actions(Driver.getDriver());
        actions.dragAndDrop(dragDropCirclePage.smallCircle, dragDropCirclePage.bigCircle)
                .pause(2000)
                .build()
                .perform();
    }
   @Test
    public void dragDrop(){
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
    }
}
