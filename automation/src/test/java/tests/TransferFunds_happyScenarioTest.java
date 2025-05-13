package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Login_Page;
import pages.OpenNewAcc_Page;
import pages.Register_Page;
import pages.TransferFunds_Page;

public class TransferFunds_happyScenarioTest extends TestBase {
    Login_Page loginPage = new Login_Page(driver);
    TransferFunds_Page transferFunds = new TransferFunds_Page(driver);

    @Test (priority = 1)
    public void test_OpenNewAccount() throws InterruptedException {
//
        loginPage.login("Gehad", "0");
        Thread.sleep(3000);
        transferFunds.openTransferFundsPage();
        Thread.sleep(3000);
        transferFunds.userCanEnterAmountOfMoney("26400");
        Thread.sleep(1000);
        transferFunds.selectFromAccountID();
        transferFunds.selectToAccountID();
        transferFunds.transferSubmit();
        Thread.sleep(1000);

        Assert.assertEquals("Transfer Complete!", transferFunds.transferCompleteMessage.getText());
    }
}
