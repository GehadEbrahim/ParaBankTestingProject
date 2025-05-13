package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home_Page;
import pages.Login_Page;
import pages.OpenNewAcc_Page;
import pages.Register_Page;
import pages.UpdateProfilePage;

public class UpdateContactInfo_HappyScenario extends TestBase{
	UpdateProfilePage updateProfilePage = new UpdateProfilePage(driver);
    Login_Page login = new Login_Page(driver);
	Home_Page homePage = new Home_Page(driver);
    @Test
    public void test_OpenNewAccount() throws InterruptedException {
    	
    	login.login("Gehad", "0");
    	updateProfilePage.openUpdateContactInfoPage();
    	Thread.sleep(1000);
    	updateProfilePage.UpdateContactInfo("Gehad" , "Ebrahim" , "XXX" , "XXX" , "XXX","XX00" , "2156154654");
//    	Thread.sleep(1000);
//    	Assert.assertEquals("Profile Updated", updateProfilePage.successMsg); => The Assert has to be modified "There is a logic error "
        
    }
}