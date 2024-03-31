package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DynamicControlPage {
    public DynamicControlPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath ="//*[.='Add']" )
    public WebElement addButton;
    @FindBy(xpath ="//*[.='Remove']" )
    public WebElement removeButton;
    @FindBy(xpath ="//*[.='Enable']" )
    public WebElement enableButton;
    @FindBy(xpath ="//*[.='Disable']" )
    public WebElement disableButton;
    @FindBy(xpath ="//*[@type='checkbox']" )
    public WebElement checkBox;
    @FindBy(xpath ="//p[@id='message']" )
    public WebElement message;
    @FindBy(xpath ="//p[@id='message']" )
    public WebElement messageBack;



}
