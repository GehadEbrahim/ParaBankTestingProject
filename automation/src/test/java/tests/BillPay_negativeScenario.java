package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BillPay_Page;
import pages.Login_Page;

public class BillPay_negativeScenario extends TestBase {
    Login_Page loginPage = new Login_Page(driver);
    BillPay_Page billPage = new BillPay_Page(driver);

    @Test (priority = 2)
    public void test_BillPay() throws InterruptedException {
        loginPage.login("Gehad", "0");
        Thread.sleep(3000);
        billPage.openBillPay_Page();
        billPage.fillBillPayForm("Gehad", "3rd EL-Sallam 2008","Giza","Nasr","213","5464641501","fjfj","asdf","ads");
        billPage.sendPaymentSubmit();
        Thread.sleep(2000);
        Assert.assertEquals("Please enter a valid number.", billPage.invalidDataMessage.getText());
    }
}
