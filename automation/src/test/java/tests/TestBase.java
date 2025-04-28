package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	  WebDriver driver = new ChromeDriver();
	  String baseURL ="https://parabank.parasoft.com/parabank/";
	  
	  @BeforeTest
	  public void openBrowser() {
		  driver.manage().window().maximize();
		  driver.navigate().to(baseURL);
	  }

	  @AfterTest
	  public void closeBrowser() {
		  driver.quit();
	  }

	}
