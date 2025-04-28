package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import pages.Home_Page;
import pages.Register_Page;


public class RegisterTest extends TestBase {
    
    @Test(priority = 1)
    public void testSuccessfulRegistration() throws InterruptedException {
    	
        Home_Page homePage = new Home_Page(driver);
        homePage.clickRegisterLink();
        Register_Page registerPage = new Register_Page(driver);
        
        Assert.assertEquals(Register_Page.pageTitle.getText(), "Signing up is easy!");
        
        registerPage.registerCustomer(
            "Menna",
            "Helmy",
            "123 Main St",
            "Anytown",
            "CA",
            "90210",
            "555-123-4567",
            "123-45-6789",
            "Jihaaad",
            "0"
        );
        Thread.sleep(3000);
        
        
        Assert.assertTrue(homePage.getWelcomeMessageText().contains("Welcome"));
    }
    
 
}