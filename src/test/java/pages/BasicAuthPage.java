package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BasicAuthPage {
    public BasicAuthPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//p[contains(text(),'Congratulations! You must have the proper credenti')]")
    public WebElement text;


}
