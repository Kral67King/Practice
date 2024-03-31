package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CheckBoxPage {
    public  CheckBoxPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
@FindBy(xpath = "//input[@id='box2']")
    public WebElement checkBox_2;
    @FindBy(xpath = "//input[@id='box1']")
    public WebElement checkBox_1;
}
