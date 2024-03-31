package Practice;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AutoCompletePage;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;
import java.util.stream.Collectors;

public class DataProviders {
    HomePage homePage=new HomePage();
    AutoCompletePage autocomplete=new AutoCompletePage();
    @Test(dataProvider = "searchBoxValue")
    public void match(String value) {
        Driver.getDriver().get(ConfigurationReader.getProperty("homeUrl"));
        System.out.println("Test with value: " + value);
        homePage.autoComplete.click();
        autocomplete.searchBox.sendKeys(value);

        List<String> listOfCountry = autocomplete.listOfCountry.stream()
                .map(element->element.getText()).collect(Collectors.toList());
        System.out.println("listOfCountry = " + listOfCountry);
        for (String s : listOfCountry) {
            Assert.assertTrue(s.contains(value));
        }

    }

    @DataProvider(name = "searchBoxValue")

    public Object[][] matchClick() {

        return new Object[][]

                {
                        {"Ca"},
                        {"Un"},
                        {"Al"},
                        {"Es"},
                        {"Ka"},
                        {"Po"},
                };
    }
    @AfterTest
    public void closingDriver(){
        Driver.getDriver().close();
    }
}
