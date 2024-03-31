package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DragDropCirclePage {
    public DragDropCirclePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "div[id='draggable']")
    public WebElement smallCircle;
    @FindBy(css = "div[id='droptarget']")
    public WebElement bigCircle;
}
