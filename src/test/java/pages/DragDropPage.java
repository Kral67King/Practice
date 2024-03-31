package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DragDropPage {
    public DragDropPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@id='column-a']")
    public WebElement squareA;
    @FindBy(xpath = "//div[@id='column-b']")
    public WebElement squareB;
}
