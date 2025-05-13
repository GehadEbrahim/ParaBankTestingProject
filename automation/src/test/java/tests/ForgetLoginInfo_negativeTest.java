package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ForgetLoginPage;
import pages.Home_Page;
import pages.Login_Page;

public class ForgetLoginInfo_negativeTest extends TestBase {

	Home_Page homePage = new Home_Page(driver);
	Login_Page loginPage = new Login_Page(driver);
	ForgetLoginPage forgetLoginPage = new ForgetLoginPage(driver);
	@Test(priority = 1)
	public void testFailedForgetLoginInfo() throws InterruptedException {

		homePage.forgotLoginLink.click();


		Assert.assertEquals(forgetLoginPage.getPageTitle(), "Customer Lookup");

		forgetLoginPage.fillCustomerLookupForm("Menna", "Helmy", "123 Main St", "Anytown", "CA", "90210", "123-45-6789");

		forgetLoginPage.clickFindMyLoginInfo();
		Thread.sleep(3000);

		Assert.assertEquals(forgetLoginPage.errorTitle.getText(), "Error!");
		Assert.assertEquals(forgetLoginPage.errorMessage.getText(), "The customer information provided could not be found.");



	}


}
