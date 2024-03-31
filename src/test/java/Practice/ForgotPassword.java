package Practice;

import base.HomeBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.HomePage;
import utilities.Driver;

public class ForgotPassword extends HomeBase {
    HomePage homePage =new HomePage();
    ForgotPasswordPage email=new ForgotPasswordPage();

@Test
    public void forgotPassword(){
    homePage.forgotPassword.click();
    email.emailInput.sendKeys("EnesKral@gmail.com");
    email.submit.click();
    String title = Driver.getDriver().getTitle();
    String expectedTitle="Net::SMTPAuthenticationError at /forgot_password";
    Assert.assertEquals(title,expectedTitle);

}
}
