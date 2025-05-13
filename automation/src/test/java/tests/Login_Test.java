package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.Assert;
import pages.Home_Page;
import pages.Login_Page;



public class Login_Test extends TestBase{
	Home_Page homePage = new Home_Page(driver);
	Login_Page loginPage = new Login_Page(driver);

	@DataProvider(name ="LoginHappyData")
	public Object[][] loginTestData(){
		Object[][] data = new Object[][] {
				{"Mena", "0"},
				{"Gehad", "0"},
		};
		return data ;
	}

	@Test(dataProvider = "LoginHappyData")
	public void successfulLoginTest(String username , String password) throws InterruptedException {
		Assert.assertEquals(loginPage.getLoginTitle(), "Customer Login");
		loginPage.login(username, password);
		Assert.assertTrue(homePage.getWelcomeMessageText().contains("Welcome"));
		loginPage.logout();

	}

}
