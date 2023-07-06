package tests;

import model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase {

 Logger logger=LoggerFactory.getLogger(AddNewContact.class);

    @BeforeMethod
    public void preconditions() {
        String email = "hw@hw", password = "Oleg123$";
        if (!app.getUser().isLogged()) {
            app.getUser().openLoginForm();
            app.getUser().fillLoginForm(email, password);
            app.getUser().submitLogin();
            app.getUser().pause(3000);

        }
    }
        @Test(invocationCount =1)
        public void addNewContactPositive(){
            int i = (int) (System.currentTimeMillis() / 1000) % 3600;
            Contact contact=Contact.builder()
                    .name("Oleg"+i)
                    .lastName("Kori")
                    .phone("123656589"+i)
                    .email("oleg"+i+"@gmail.com")
                    .address("Rehovot")
                    .description("Best Friend")
                    .build();
logger.info("Phone number is"+contact.getPhone());
            app.getHelperContact().openContactForm();
            app.getHelperContact().fillContactForm(contact);
            app.getHelperContact().pause(3000);
app.getHelperContact().submitContact();
            Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
        }
    }
