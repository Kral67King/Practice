package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.FramePage;
import utilities.BrowserUtils;

public class Frame {
    FramePage framePage=new FramePage();
    @And("user click iFrame")
    public void userClickIFrame() {
        BrowserUtils.scrollToElement(framePage.iframe);
        framePage.iframe.click();
    }
}
