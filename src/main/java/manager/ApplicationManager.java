package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);
   // WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;
    HelperContact helperContact;
    HelperDeleteContact helperDeleteContact;

    public HelperUser getUser() {

        return user;
    }

    public HelperContact getHelperContact() {

        return helperContact;
    }

    public HelperDeleteContact getHelperDeleteContact() {
        return helperDeleteContact;
    }

    @BeforeSuite
    public void init(){
       // wd = new ChromeDriver();
        wd=new EventFiringWebDriver(new ChromeDriver());
        wd.register(new WebDriverListener());
        user = new HelperUser(wd);
       helperContact=new HelperContact(wd);

helperDeleteContact = new HelperDeleteContact(wd);
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown(){
       // wd.quit();
    }
}
