package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ForgetLoginPage;
import pages.Home_Page;
import pages.Login_Page;

public class ForgetLoginInfo_HappyTest extends TestBase {
	
	Home_Page homePage = new Home_Page(driver);
	Login_Page loginPage = new Login_Page(driver);
	@Test(priority = 1)
	public void testSuccessfulForgetLoginInfo() throws InterruptedException {
		
		homePage.forgotLoginLink.click();

	    ForgetLoginPage forgetLoginPage = new ForgetLoginPage(driver);

	    Assert.assertEquals(forgetLoginPage.getPageTitle(), "Customer Lookup");

	    forgetLoginPage.fillCustomerLookupForm("Menna", "Helmy", "123 Main St", "Anytown", "CA", "90210", "123-45-6789");

	    forgetLoginPage.clickFindMyLoginInfo();
	    Thread.sleep(3000);
		
		
		
	}

}
