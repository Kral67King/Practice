package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ForgotPasswordPage {
    public ForgotPasswordPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "input[name='email']")
    public WebElement emailInput;
    @FindBy(css = ".icon-2x.icon-signin")
    public WebElement submit;
}
