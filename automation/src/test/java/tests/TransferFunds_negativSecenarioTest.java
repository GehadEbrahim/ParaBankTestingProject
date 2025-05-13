
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_Page;
import pages.Register_Page;
import pages.TransferFunds_Page;

public class TransferFunds_negativSecenarioTest extends TestBase{
	Register_Page registerPage = new Register_Page(driver);
	Login_Page loginPage = new Login_Page(driver);
	TransferFunds_Page transferFunds = new TransferFunds_Page(driver);

	@Test (priority = 2)
	public void userCannotTransferFund() throws InterruptedException {
		loginPage.login("Gehad", "0");
		Thread.sleep(3000);
		transferFunds.openTransferFundsPage();
		Thread.sleep(3000);
		transferFunds.userCanEnterAmountOfMoney("jk");
		transferFunds.transferSubmit();

		Thread.sleep(3000);
		Assert.assertEquals("Error!", transferFunds.errorTransferFunds.getText());
	}
}
