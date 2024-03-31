package stepdefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import pages.BrokenImagePage;

public class BrokenImage {
 BrokenImagePage brokenImage=new BrokenImagePage();
    @And("user able to find brokenImages")
    public void userAbleToFindBrokenImages() {
        for (WebElement image : brokenImage.images) {
            if(image.getAttribute("naturalWidth").equals("0")){
                System.out.println("image is broken = " + image.getAttribute("src"));
            }
            else{
                System.out.println("image is Ok = " + image.getAttribute("src"));
            }
        }
    }
}
