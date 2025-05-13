package tests;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ParaBankLoanRequestTest {
	WebDriver driver=new ChromeDriver();
	String baseURL="https://parabank.parasoft.com/parabank/requestloan.htm";

		
		
	
	@BeforeTest
	  public void openBrowser() {
		  driver.manage().window().maximize();
		driver.navigate().to(baseURL);//to open web on this page
	      
	}
	@Test(priority=1)
	public void testLoanRequest_positiveScerario() throws InterruptedException {
		WebElement loanAmount=driver.findElement(By.id("amount"));
		loanAmount.sendKeys("5000");
		
		WebElement downPayment= driver.findElement(By.id("downPayment"));
		downPayment.sendKeys("1000");
		
		WebElement fromAccountDropDown= driver.findElement(By.id("fromAccountId"));
	    Select makeFromAccountDropDown= new Select(fromAccountDropDown);
	  Assert.assertEquals(1, makeFromAccountDropDown.getOptions().size());
	  Assert.assertFalse(makeFromAccountDropDown.isMultiple());
  
	  makeFromAccountDropDown.selectByIndex(0);

		List<WebElement> options=makeFromAccountDropDown.getOptions();
		
		for(int i=0; i<options.size();++i)
		{
			System.out.println(options.get(i).getText());
		}
		
		Thread.sleep(1000);
		WebElement applyNowBtn= driver.findElement(By.className("button"));
		applyNowBtn.click();
		Assert.assertEquals("Apply Now", applyNowBtn.getText());
        WebElement result=driver.findElement(By.id("loanStatus"));
        Assert.assertEquals("Denied", result.getText());

	
	}
	@Test(priority=2, dependsOnMethods =  {"testLoanRequest_positiveScerario"})
	public void testLoanRequest_negativeScerario() throws InterruptedException {
		WebElement applyNowBtn= driver.findElement(By.className("button"));
		applyNowBtn.click();

		WebElement faildMessage= driver.findElement(By.className("error"));
		 Assert.assertTrue(faildMessage.getText().contains("An internal error has occurred and has been logged."));

		
		
	
		
		
	}

	  @AfterTest
	  public void closeBrowser() {
		driver.close();  
	  }

	}