package Practice;

import base.HomeBase;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AutoCompletePage;
import pages.HomePage;
import pages.Indexes;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;
import java.util.stream.Collectors;

public class Autocomplete extends HomeBase {
    HomePage homePage = new HomePage();
    AutoCompletePage autocomplete = new AutoCompletePage();

    @Test
    //Text include String
    public void autoComplete() {
        homePage.autoComplete.click();
        autocomplete.searchBox.sendKeys("Ca");

        List<String> listOfCountry = autocomplete.listOfCountry.stream()
                .map(element -> element.getText()).collect(Collectors.toList());
        System.out.println("listOfCountry = " + listOfCountry);
        for (String s : listOfCountry) {
            Assert.assertTrue(s.contains("Ca"));
        }
    }

    @Test
    public void placeHolder() {
        homePage.autoComplete.click();
        String placeholder = autocomplete.searchBox.getAttribute("placeholder");
        System.out.println("placeholder = " + placeholder);
        Assert.assertEquals(placeholder, "Country");
    }

    @Test
    public void selection() {
        homePage.autoComplete.click();
        autocomplete.searchBox.sendKeys("Ca");

        for (WebElement webElement : autocomplete.listOfCountry) {
            if (webElement.getText().equals("Canada")) {
                webElement.click();
                break;
            }
        }
        BrowserUtils.sleep(2);
        autocomplete.submit.click();

        String actualText = autocomplete.text.getText();
        String expectedText="You selected: Canada";
        Assert.assertEquals(actualText,expectedText);

    }
}


