package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.AdminPage;

public class AdminPageTest extends TestBase{

    WebDriver driver;
    AdminPage adminPage = new AdminPage(driver);

    @Test
    public void testAdminSettingsSubmission() throws InterruptedException {
    	Thread.sleep(2000);

    	adminPage.OpenAdminPage();
    	Thread.sleep(2000);
        adminPage.setDatabase("jdbc:mysql://parabank.parasoft.com/parabank", "admin", "admin123");


        adminPage.enableJmsService(true, "tcp://parabank.parasoft.com:61616");


        adminPage.selectDataAccessMode("REST_JSON");


        adminPage.setWebServiceEndpoint("http://parabank.parasoft.com/api");


        adminPage.setApplicationSettings("10000", "500");


        adminPage.submitSettings();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}