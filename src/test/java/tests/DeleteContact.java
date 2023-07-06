package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContact extends TestBase {
    // Logger logger= LoggerFactory.getLogger(AddNewContact.class);

    @BeforeMethod
    public void preconditions() {
        String email = "hw@hw", password = "Oleg123$";
        if (!app.getUser().isLogged()) {
            app.getUser().openLoginForm();
            app.getUser().pause(3000);
            app.getUser().fillLoginForm(email, password);
            app.getUser().pause(3000);
            app.getUser().submitLogin();
            app.getUser().pause(3000);

        }
    }


    @Test

    public void deleteContact() {
        //  logger.info("Delete contact");
       // String location = "//div[@class='contact-item_card__2SOIM'][position()=4]";
        app.getHelperDeleteContact().findContact();
        app.getHelperDeleteContact().remove();
        Assert.assertTrue(app.getHelperDeleteContact().isElementDeleted());


    }
}