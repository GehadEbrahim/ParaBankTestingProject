package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home_Page;
import pages.Register_Page;

public class Register_negativeScenario extends TestBase{
	Home_Page homePage = new Home_Page(driver);
	Register_Page registerPage = new Register_Page(driver);
	@Test (priority = 2)
	public void Register_ExistUserName() throws InterruptedException {
		homePage.clickRegisterLink();
		Assert.assertEquals(Register_Page.pageTitle.getText(), "Signing up is easy!");

		registerPage.registerCustomer(
				"Menna",
				"Helmy",
				"123 Main St",
				"Anytown",
				"CA",
				"90210",
				"555-123-4567454",
				"123-45-6789",
				"Jehad",
				"0"
		);
		Thread.sleep(3000);


		Assert.assertEquals(registerPage.usernameErrorMessage.getText(), "This username already exists.");

	}

}
