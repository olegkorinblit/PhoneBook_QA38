package tests;

import manager.TestNgListener;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNgListener.class)
public class Reg$LogTests extends TestBase {
//    @BeforeMethod
//    public  void precondition() {
//        if(app.getUser().isLogged()){
//            app.getUser().Logout();
//    }



    @Test
    public void registrationPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "abc" + i + "@def.com", password = "$Abcdef12345";
        app.getUser().openLoginForm();
        logger.info("openLoginForm invoked");
        app.getUser().fillLoginForm(email, password);
        logger.info("fillLoginForm invoked");
        app.getUser().submitRegistration();
        logger.info("submitRegistration invoked");
        app.getUser().pause(5000);
        logger.info("RegistrationPositive starts with credentials:login  "
                + email+" and password:  "+ password);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

    }

    @Test
    public void registrationNegativeWrongEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "abc" + i + "def.com", password = "$Abcdef12345";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
    }


    @Test
    public void registrationNegativeWrongPassword() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "hw@hw", password = "Oleg" + i + "12345";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
    }

    @Test
    public void loginPositiveTest() {
        //    int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "hw@hw", password = "Oleg123$";
        //open login form
       app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().pause(5000);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @Test
    public  void loginNegativeWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
       // String email = "hwhw"+i+"@gmail.com", password = "Oleg123$";
        String email = "hwhw1312", password = "Oleg123$";
        //open login form
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
//Assert.assertTrue();
   //  app.getUser().isAlertPresent();
        Assert.assertTrue(app.getUser().isWrongFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
    @Test
    public  void loginNegativePassword(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "hw@hw";
        String password = "Oleg"+i+"";
        //open login form
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
    }
    @Test
    public void loginNegativeWrongEmail1(){
        String email = "abcdef.com", password = "$Abcdef12345";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
//        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isWrongFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}