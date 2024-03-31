package Practice;

import base.HomeBase;
import org.testng.annotations.Test;
import pages.DisappearingPage;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class Disappearing extends HomeBase {
    HomePage homePage=new HomePage();
    DisappearingPage disappearingPage=new DisappearingPage();
    @Test
    public void textValidation(){
      homePage.disappearingElements.click();
      List<String> list=new ArrayList<>();
        for (int i = 1; i < disappearingPage.listOfElements.size(); i++) {
            list.add(disappearingPage.listOfElements.get(i).getText());
        }
        System.out.println("list = " + list);
        for (int i = 1; i < disappearingPage.listOfElements.size(); i++) {
            list.add(disappearingPage.listOfElements.get(i).getText());
            if(disappearingPage.listOfElements.get(i).getText().equals("About")){
                disappearingPage.listOfElements.get(i).click();
                break;
            }
        }
        BrowserUtils.sleep(3);
        System.out.println("url = " + Driver.getDriver().getCurrentUrl());

    }
}
