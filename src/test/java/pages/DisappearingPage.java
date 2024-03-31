package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DisappearingPage {
    public DisappearingPage(){
        PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "//li//a")
    public List<WebElement>listOfElements;
}
