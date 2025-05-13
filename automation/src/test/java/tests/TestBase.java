package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import data.LoadDriverProperties;

public class TestBase {

	WebDriver driver;
	String baseURL = LoadDriverProperties.driverData.getProperty("baseURL");
	String browserName = LoadDriverProperties.driverData.getProperty("browserName");
	public TestBase() {
		if(browserName.equals("Chrome"))
			driver = new ChromeDriver();
		else if(browserName.equals("edge"))
			driver = new EdgeDriver();
	}
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
