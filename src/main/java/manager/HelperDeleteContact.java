package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class HelperDeleteContact extends HelperBase {
    public HelperDeleteContact(WebDriver wd) {
        super(wd);
    }


    int size1,size2;

    public void findContact() {
size1 = wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM'] ")).size();




        click(By.xpath("//div[@class='contact-item_card__2SOIM'][position()=4] "));
    }

    public void remove() {
        click(By.xpath("//button[.='Remove']"));
      //  size2 = wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM'] ")).size();
    }

    public boolean isElementDeleted() {
        size2 = wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM'] ")).size();
       return size2>size1;
    }
}