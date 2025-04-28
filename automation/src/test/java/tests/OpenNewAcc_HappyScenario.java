package tests;

import org.testng.annotations.Test;
import pages.Home_Page;
import pages.Login_Page;
import pages.OpenNewAcc_Page;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class OpenNewAcc_HappyScenario extends TestBase {
    
    Login_Page loginPage = new Login_Page(driver);
    OpenNewAcc_Page openNewAcc = new OpenNewAcc_Page(driver);
        
    @Test
    public void test_OpenNewAccount() throws InterruptedException {
        loginPage.login("Gehad", "0");
        Thread.sleep(3000);
        openNewAcc.openNewAccountPage();
        Thread.sleep(3000);
        openNewAcc.selectCheckingAccount();
        openNewAcc.selectSavingsAccount();
        openNewAcc.verifyAccountIdIsNumeric();
        openNewAcc.openNewAccSubmit();
        
        Thread.sleep(3000);
        Assert.assertEquals("Congratulations, your account is now open.", openNewAcc.congratesMessage.getText());
    }
}