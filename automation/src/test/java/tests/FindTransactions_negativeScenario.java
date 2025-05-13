package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.FindTransactionsPage;
import pages.Login_Page;

public class FindTransactions_negativeScenario extends TestBase{
    Login_Page loginPage = new Login_Page(driver);
    FindTransactionsPage findTransactionsPage = new FindTransactionsPage(driver);
    Duration duration = Duration.ofSeconds(3);
    String errorMsg;

    @Test
    public void testFindTransactions_negativeScenario() throws InterruptedException
    {
        loginPage.login("Gehad", "0");
        findTransactionsPage.open();

        // write invalid date
        findTransactionsPage.findByDate("n");
        findTransactionsPage.clickDateBtn();


        errorMsg = findTransactionsPage.getDateErrorMsg();
        Thread.sleep(duration);

        // write invalid date range
        findTransactionsPage.findByDateRange("2a-01-2025", "2b-01-2025");
        findTransactionsPage.clickDateRangeBtn();

        errorMsg = findTransactionsPage.getDateRangeErrorMsg();
        assertEquals(errorMsg, "Invalid date format", "The error message should be 'Invalid date format'.");

        // write invalid amount
        findTransactionsPage.findByAmount("12ab");
        findTransactionsPage.clickAmountBtn();

        errorMsg = findTransactionsPage.getAmountErrorMsg();
        assertEquals(errorMsg, "Invalid amount", "The error message should be 'Invalid amount'.");
    }

}
