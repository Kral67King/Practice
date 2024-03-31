package Playwright.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormAuthPagePL {
    public String userName="//input[@name='username']";
    public String password="//input[@name='password']";
    @FindBy(xpath = "//button")
    public String loginButton="//button";
    public String message="#flash-messages";
    public String logOutButton=".button";
}
