package tests;

import org.testng.annotations.Test;

import org.testng.Assert;
import pages.Home_Page;
import pages.Login_Page;

public class Login_negativeScenario extends TestBase {
	Home_Page homePage = new Home_Page(driver);
	Login_Page loginPage = new Login_Page(driver);
	
	@Test(priority = 1)
    public void successfulLoginTest() throws InterruptedException {
		
		Assert.assertEquals(loginPage.getLoginTitle(), "Customer Login");
		
		loginPage.login("Jehad", "hf");
		
		Thread.sleep(3000);
		
		Assert.assertEquals(loginPage.errorTitle.getText(), "Error!");
	    Assert.assertEquals(loginPage.errorMessage.getText(), "The username and password could not be verified.");
		
	}
}
