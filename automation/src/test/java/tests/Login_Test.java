package tests;

import org.testng.annotations.Test;

import org.testng.Assert;
import pages.Home_Page;
import pages.Login_Page;


public class Login_Test extends TestBase{
	
	Home_Page homePage = new Home_Page(driver);
	Login_Page loginPage = new Login_Page(driver);
	
	@Test(priority = 1)
    public void successfulLoginTest() throws InterruptedException {
		
		Assert.assertEquals(loginPage.getLoginTitle(), "Customer Login");
		
		loginPage.login("Jehad", "0");
		
		Thread.sleep(1000);
		
		Assert.assertTrue(homePage.getWelcomeMessageText().contains("Welcome"));
		Thread.sleep(500);
		
	}

}
