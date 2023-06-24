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

public class LoginTests {
    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().window().maximize();
    }

    @Test
    public void loginPositiveTest() {
        //open login form
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
       passwordInput.sendKeys("Oleg123$");
        //click on button login
        wd.findElement(By.xpath("//button[1]")).click();
        //Assert
     //   Assert.assertTrue(wd.findElements(By.xpath("//*[.a'Sign Out']")).size()>0);
        Assert.assertTrue(wd.findElements(By.xpath("//button")).size()>0);


    }

    @Test
    public  void loginNegativeWrongEmail()
    {
        //open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("hwhw");

        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Oleg123$");
        //click on button login
        wd.findElement(By.xpath("//button")).click();
        //Assert

    }
    @Test
    public  void loginNegativePassword()
    {
        //open login form
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
        passwordInput.sendKeys("hwhw");
        //click on button login
        wd.findElement(By.xpath("//button")).click();
        //Assert

    }

    @AfterMethod
public void tearDown(){

        }

    }

