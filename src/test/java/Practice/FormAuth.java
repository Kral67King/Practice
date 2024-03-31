package Practice;

import base.HomeBase;
import org.testng.annotations.Test;
import pages.FormAuthPage;
import pages.HomePage;
import utilities.BrowserUtils;

public class FormAuth extends HomeBase {
    HomePage homePage=new HomePage();
    FormAuthPage formAuthPage=new FormAuthPage();
    @Test
    public  void login(){
        homePage.formAuth.click();
        formAuthPage.userName.sendKeys("tomsmith");
        formAuthPage.password.sendKeys("SuperSecretPassword");
        formAuthPage.loginButton.click();
        String text = formAuthPage.message.getText();
        System.out.println("text = " + text);
        formAuthPage.logOutButton.click();
        BrowserUtils.sleep(2);


    }
}
