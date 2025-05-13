package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BillPay_Page;
import pages.Login_Page;

public class BillPay_happyScenario extends TestBase {
    Login_Page loginPage = new Login_Page(driver);
    BillPay_Page billPage = new BillPay_Page(driver);

    @Test (priority = 1)
    public void test_BillPay() throws InterruptedException {
        loginPage.login("Gehad", "0");
        Thread.sleep(3000);
        billPage.openBillPay_Page();
        billPage.fillBillPayForm("Gehad", "3rd EL-Sallam 2008","Giza","Nasr","213","5464641501","12035","12035","5645");
        billPage.sendPaymentSubmit();
        Thread.sleep(2000);
        Assert.assertEquals("Bill Payment Complete", billPage.paymentSuccessMessage.getText());
    }
}
