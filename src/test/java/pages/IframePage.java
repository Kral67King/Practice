package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class IframePage {
    public IframePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//frame[@name='frame-top']")
    public WebElement topFrame;
    @FindBy(xpath = "//frame[@name='frame-left']")
    public WebElement leftFrame;
    @FindBy(xpath = "//frame[@name='frame-middle']")
    public WebElement middleFrame;
    @FindBy(xpath = "//frame[@name='frame-right']")
    public WebElement rightFrame;
    @FindBy(xpath = "//frame[@name='frame-bottom']")
    public WebElement bottomFrame;
    @FindBy(xpath = "//a[.='Nested Frames']")
    public WebElement nestedFrame;
    @FindBy(xpath = "//a[.='iFrame']")
    public WebElement iFrame;
    @FindBy(xpath = "//body")
    public WebElement text;


}
