package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FormAuthPage {
    public FormAuthPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;
    @FindBy(xpath = "//button")
    public WebElement loginButton;
    @FindBy(css = "#flash-messages")
    public WebElement message;
    @FindBy(css = ".button")
    public WebElement logOutButton;
}
