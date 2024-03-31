package Playwright.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutoCompletePagePL {
    public String listOfCountry= "//div[@id='myCountryautocomplete-list']//div";
    public String searchBox= "input[id='myCountry']";
    public String submit= "input[type='button']";
    public String text= "//*[.='You selected: Canada']";


}
