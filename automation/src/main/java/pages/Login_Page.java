package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Login_Page extends PageBase{

	public Login_Page(WebDriver driver) {
		super(driver);
	}
	 	@FindBy(name = "username")
	    WebElement usernameInput;

	    @FindBy(name = "password")
	    WebElement passwordInput;

	    @FindBy(xpath = "//input[@value='Log In']")
	    WebElement loginButton;
	    
	    @FindBy(xpath = "//div[@id='leftPanel']/h2")
	    WebElement customerLoginTitle;
	    
	    @FindBy(xpath = "//h1[@class='title']")
		public WebElement errorTitle;

	    @FindBy(xpath = "//p[@class='error']")
		public
	    WebElement errorMessage;

	    
	    public void login(String username, String password) {
	        usernameInput.sendKeys(username);
	        passwordInput.sendKeys(password);
	        loginButton.click();
	    }

	    public String getLoginTitle() {
	        return customerLoginTitle.getText();
	    }
	    


}
