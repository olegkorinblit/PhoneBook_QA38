/*package logandregist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tests.TestBase;

import java.util.concurrent.TimeUnit;

public class RegistrationTests1  {

@Test
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "abc" + i + "@def.com", password = "$Abcdef12345";
        openLoginForm();
        fillLoginForm(email, password);
        submitRegistration();
        pause(5000);
        Assert.assertTrue(isElementPresent(By.xpath("//button")));



        // Assert

//        Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
        pause(5000);
        Assert.assertTrue(isElementPresent(By.xpath("//button")));


    }

    CW:

https://github.com/QA38Rehovot/StartSelenium_QA38
https://github.com/QA38Rehovot/PhoneBook_QA38


HW:

Task 1.
Создать негативный тестовый метод (неверный password) на регистрацию в классе RegistrationTests с применением TestBase.
Task 2.
Создать негативный тестовый метод (неверный password) на логин в классе LoginTests с применением TestBase.

Task3***
На сайте https://www.leumi.co.il/ найти локатор для элемента <span>פרטי</span> и вывести его содержимое в консоль. При возникновении проблем воспользоваться сервисом https://chat.openai.com/chat для поиска решения.

Д/З высылать на почту webinartelran@gmail.com до 20:00 дня накануне лекции

    @Test
    public void registrationNegativeWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "abc" + i + "def.com", password = "$Abcdef12345";
        openLoginForm();
        fillLoginForm(email, password);
        submitRegistration();
    }



@Test
public  void registrationNegativeWrongPassword() {

        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "hw@hw", password = "Oleg"+i+"12345";
    openLoginForm();
    fillLoginForm(email, password);
    submitRegistration();

    int x = (int) (System.currentTimeMillis() / 1000) / 3600;
    wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    // fill login form
    WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
    emailInput.click();
    emailInput.clear();
    emailInput.sendKeys("hw@hw");

    WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
    passwordInput.click();
    passwordInput.clear();
    passwordInput.sendKeys(x + "1");

    //click on button registration

    wd.findElement(By.xpath("//button[2]")).click();
    //Assert


}
    @AfterMethod
    public void tearDown(){

    }
}
*/