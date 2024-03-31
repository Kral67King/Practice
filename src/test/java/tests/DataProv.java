package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Indexes;
import utilities.ConfigurationReader;
import utilities.Driver;

public class DataProv {
    Indexes indexes=new Indexes();
    @Test(dataProvider = "CheckBoxSelection")
    public void checkBoxDP(String value) {
        System.out.println("Test with value: " + value);
        Driver.getDriver().get(ConfigurationReader.getProperty("testUrl"));
        indexes.clickCheckBox(value);
    }

    @DataProvider(name = "CheckBoxSelection")

    public Object[][] CheckBoxData() {

        return new Object[][]

                {
                        {"Equity"},
                        {"Fixed Income"},
                        {"Multi Asset"},
                        {"Alternatives"},
                        {"ESG"},
                        {"Private Markets"},
                        {"Strategic Beta"},

                };
    }

    @Test(dataProvider = "MatchClick")
    public void match(String value) {
        System.out.println("Test with value: " + value);
        Driver.getDriver().get(ConfigurationReader.getProperty("testUrl"));
        indexes.matchClick(value);
    }

    @DataProvider(name = "MatchClick")

    public Object[][] matchClick() {

        return new Object[][]

                {
                        {"Equity"},
                        {"Fixed Income"},
                        {"Multi Asset"},
                        {"Alternatives"},
                        {"ESG"},
                        {"Private Markets"},
                };
    }
    @AfterTest
    public void tearDown(){
        Driver.getDriver().close();
    }
}
