package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.AdminPage;

public class AdminPageTest{

    WebDriver driver;
    AdminPage adminPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://parabank.parasoft.com/ParaBankAdminPanel/admin.htm");
        adminPage = new AdminPage(driver);
    }

    @Test
    public void testAdminSettingsSubmission() {
        adminPage.selectDataAccessMode("REST_JSON");

        adminPage.setWebServiceEndpoints(
                "http://parabank.parasoft.com/soap",
                "http://parabank.parasoft.com/rest",
                "http://parabank.parasoft.com/loan"
        );

        adminPage.setApplicationSettings(
                "10000",
                "500",
                "Web Service",
                "Available Funds",
                "20"
        );

        adminPage.submitSettings();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}