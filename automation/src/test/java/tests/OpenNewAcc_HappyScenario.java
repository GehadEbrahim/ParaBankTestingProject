package tests;

import org.testng.annotations.Test;
import pages.Home_Page;
import pages.Login_Page;
import pages.OpenNewAcc_Page;
import pages.Register_Page;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class OpenNewAcc_HappyScenario extends TestBase {

    OpenNewAcc_Page openNewAcc = new OpenNewAcc_Page(driver);
    Register_Page registerPage = new Register_Page(driver);
    Home_Page homePage = new Home_Page(driver);
    @Test
    public void test_OpenNewAccount() throws InterruptedException {
        boolean isLoggedIn = openNewAcc.isLoggedIn("Mena", "0");
        if (!isLoggedIn) {
            homePage.clickRegisterLink();
            registerPage.registerCustomer(
                    "Menna",
                    "Helmy",
                    "123 Main St",
                    "Anytown",
                    "CA",
                    "90210",
                    "555-123-4567",
                    "123-45-6789",
                    "8",
                    "0"
            );
        }
        openNewAcc.openNewAccountPage();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type")));
        //Open a checking account
        openNewAcc.selectCheckingAccount();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#type > option:nth-child(1)")));
        Thread.sleep(1000);
        openNewAcc.verifyAccountIdIsNumeric();
        openNewAcc.openNewAccSubmit();
        //Open a saving account
        openNewAcc.openNewAccountPage();
        openNewAcc.selectSavingsAccount();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#type > option:nth-child(2)")));
        Thread.sleep(1000);
        openNewAcc.verifyAccountIdIsNumeric();
        openNewAcc.openNewAccSubmit();
    }
}