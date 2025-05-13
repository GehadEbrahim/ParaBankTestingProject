package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUs_Page;
import pages.Home_Page;
import pages.Login_Page;

public class ContactUs_Test extends TestBase {

    Home_Page homePage = new Home_Page(driver);
    Login_Page loginPage = new Login_Page(driver);
    ContactUs_Page contactUsPage = new ContactUs_Page(driver);
    @Test(priority = 1)
    public void testSubmitContactForm() throws InterruptedException {

        loginPage.login("MHHH", "password123");
        Thread.sleep(3000);
        homePage.clickContactUsLink();
        Assert.assertEquals(contactUsPage.getPageTitle(), "Customer Care" );

        contactUsPage.fillContactForm("Menna Helmy", "mennahassaneissa@gmail.com","01147062340", "This is a test message.");
        contactUsPage.submitContactForm();

        Thread.sleep(3000);

        Assert.assertEquals(contactUsPage.getConfirmationMessage(),"A Customer Care Representative will be contacting you.");

        Thread.sleep(3000);


    }

}
