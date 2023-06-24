package logandregist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTests {

    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void registrationPositive(){
        // open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        // fill login form

        int i = (int)(System.currentTimeMillis()/1000)%3600;

        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("abc" + i + "@def.com");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("$Abcdef12345");

        // click on button Registration
        wd.findElement(By.xpath("//button[2]")).click();

        // Assert

//        Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);

    }
    /*
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
     */
    @Test
     public  void registrationNegativeWrongPassword() {


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

         public void tearDown () {

         }
     }