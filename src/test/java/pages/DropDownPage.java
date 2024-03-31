package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DropDownPage {
    public DropDownPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//select[@id='dropdown']")
    public WebElement simpleDropDown;
    @FindBy(xpath = " //select[@id='dropdown']//option[.='Option 1']")
    public WebElement optionOne;
    @FindBy(xpath = " //select[@id='dropdown']//option[.='Option 2']")
    public WebElement optionTwo;
    @FindBy(xpath ="//select[@id='year']")
    public WebElement year;
    @FindBy(xpath ="//select[@id='month']")
    public WebElement month;
    @FindBy(xpath ="//select[@id='day']")
    public WebElement day;

}
