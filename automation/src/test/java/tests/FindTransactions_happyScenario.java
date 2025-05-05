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
	Duration duration = Duration.ofSeconds(3);
	
	@Test
    public void testFindTransactions_happyScenario() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage.login("nada", "8");
        Thread.sleep(duration);
        
        // test transaction date
        findTransactionsPage.open();
        findTransactionsPage.findByDate("01-01-2025");
        Thread.sleep(duration);
        findTransactionsPage.clickDateBtn();
        validateTransactionResults(wait);
        Thread.sleep(duration);

        // test date range
        findTransactionsPage.open();
        findTransactionsPage.findByDateRange("01-01-2025", "01-01-2026");
        Thread.sleep(duration);
        findTransactionsPage.clickDateRangeBtn();
        validateTransactionResults(wait);
        Thread.sleep(duration);

        // test amount
        findTransactionsPage.open();
        findTransactionsPage.findByAmount("30");
        Thread.sleep(duration);
        findTransactionsPage.clickAmountBtn();
        validateTransactionResults(wait);
        Thread.sleep(duration);
    }
	
    private void validateTransactionResults(WebDriverWait wait) {
        wait.until(ExpectedConditions.urlContains("findtrans.htm"));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultContainer")));
        
        String pageTitle = driver.findElement(By.cssSelector("#resultContainer h1.title")).getText();
        assertEquals(pageTitle, "Transaction Results", "The page title should be 'Transaction Results' after searching.");
    }
	
}
