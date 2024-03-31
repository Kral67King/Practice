package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutoCompletePage {
    public  AutoCompletePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@id='myCountryautocomplete-list']//div")
    public List<WebElement> listOfCountry;
    @FindBy(css = "input[id='myCountry']")
    public WebElement searchBox;
    @FindBy(css = "input[type='button']")
    public WebElement submit;
    @FindBy(xpath = "//*[.='You selected: Canada']")
    public WebElement text;


}
