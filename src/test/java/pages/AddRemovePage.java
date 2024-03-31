package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AddRemovePage {
    public AddRemovePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[normalize-space()='Add Element']")
    public WebElement addElementButton;
    @FindBy(xpath = "//button[normalize-space()='Delete']")
    public WebElement deleteButton;
    @FindBy(xpath = "//button")
    public List<WebElement> button;
}
