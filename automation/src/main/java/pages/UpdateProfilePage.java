package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateProfilePage extends PageBase {
    public UpdateProfilePage(WebDriver driver) {
		super(driver);
    }
    
    Login_Page loginPage = new Login_Page(driver);
	Home_Page homePage = new Home_Page(driver);
    
    @FindBy (css ="#leftPanel > ul > li:nth-child(6) > a")
    WebElement openUPdatePageBtn;

    @FindBy (id="customer.firstName")
    WebElement customerFirstNameTxt;
    
    @FindBy (id="customer.lastName")
    WebElement customerLastNameTxt;
    
    @FindBy (id="customer.address.street")
    WebElement customerStreetTxt;
    
    @FindBy (id="customer.address.city")
    WebElement customerCityTxt;
    
    @FindBy (id="customer.address.state")
    WebElement customerStateTxt;
    
    @FindBy (id="customer.address.zipCode")
    WebElement customerZIPCodeTxt;
    
    @FindBy (id="customer.phoneNumber")
    WebElement customerPhoneTxt;
    
    @FindBy (css = "#updateProfileForm > form > table > tbody > tr:nth-child(8) > td:nth-child(2) > input")
    WebElement UpdateSubmitBtn;
    
    @FindBy (css = "#updateProfileResult > h1")
    public WebElement successMsg; 
    
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
    
    public void openUpdateContactInfoPage() {
        openUPdatePageBtn.click();
    }
    public void UpdateContactInfo(String fname, String lname, String street, String city , String state, String zip , String numberPhn ) {
    	customerFirstNameTxt.clear();
    	customerLastNameTxt.clear();
    	customerStreetTxt.clear();
    	customerCityTxt.clear();
    	customerStateTxt.clear();
    	customerZIPCodeTxt.clear();
    	customerPhoneTxt.clear();
    	customerFirstNameTxt.sendKeys(fname);
    	customerLastNameTxt.sendKeys(lname);
    	customerStreetTxt.sendKeys(street);
    	customerCityTxt.sendKeys(city);
    	customerStateTxt.sendKeys(state);
    	customerZIPCodeTxt.sendKeys(zip);
    	customerPhoneTxt.sendKeys(numberPhn);
    	
    	UpdateSubmitBtn.click();
    }
}


















