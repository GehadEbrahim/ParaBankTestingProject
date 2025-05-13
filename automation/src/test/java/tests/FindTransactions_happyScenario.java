package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.FindTransactionsPage;
import pages.Login_Page;

public class FindTransactions_happyScenario extends TestBase{
    Login_Page loginPage = new Login_Page(driver);
    FindTransactionsPage findTransactionsPage = new FindTransactionsPage(driver);

    @Test
    public void testFindTransactions_happyScenario() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        loginPage.login("Gehad", "0");

        findTransactionsPage.open();
        findTransactionsPage.findByDate("01-01-2025");
        findTransactionsPage.clickDateBtn();
        findTransactionsPage.validateTransactionResults(wait);

        // test date range
        findTransactionsPage.open();
        findTransactionsPage.findByDateRange("01-01-2025", "01-01-2026");
        findTransactionsPage.clickDateRangeBtn();
        findTransactionsPage.validateTransactionResults(wait);

        // test amount
        findTransactionsPage.open();
        findTransactionsPage.findByAmount("30");
        findTransactionsPage.clickAmountBtn();
        findTransactionsPage.validateTransactionResults(wait);
    }



}
