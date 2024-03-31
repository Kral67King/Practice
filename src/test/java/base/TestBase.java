package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigurationReader;
import utilities.Driver;


public abstract class TestBase {

    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get(ConfigurationReader.getProperty("testUrl"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.getDriver().close();
    }

}
