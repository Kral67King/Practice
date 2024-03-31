package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.FramePage;
import utilities.BrowserUtils;
import utilities.Driver;

public class Iframe {
    FramePage framePage=new FramePage();
    @Then("User switch to iframe")
    public void userSwitchToIframe() {
       // Driver.getDriver().switchTo().frame(0);  -by index
        Driver.getDriver().switchTo().frame(framePage.frame);// by web element
    }
    @And("user able to add text inside the frame")
    public void userAbleToAddTextInsideTheFrame() {
     framePage.textBox.clear();

        framePage.addText.sendKeys("Hayirli Ramazanlar");
        BrowserUtils.sleep(4);
    }
}
