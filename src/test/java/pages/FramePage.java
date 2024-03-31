package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FramePage {
    public FramePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[.='iFrame']")
    public WebElement iframe;
     @FindBy(xpath = "//iframe[@id='mce_0_ifr']")
    public WebElement frame;
     @FindBy(xpath = "//p[contains(text(),'Your')]")
    public WebElement textBox;
     @FindBy(xpath = "//p")
    public WebElement addText;


}
