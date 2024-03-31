package base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigurationReader;
import utilities.Driver;
public abstract class HomeBase {
    @BeforeMethod   (alwaysRun = true)
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("homeUrl"));
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        Driver.getDriver().close();
    }
}
