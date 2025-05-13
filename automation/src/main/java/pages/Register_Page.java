package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register_Page extends PageBase{

	public Register_Page(WebDriver driver) {
		super(driver);

	}
	@FindBy(className = "title")
	public static WebElement pageTitle;

	@FindBy(id = "customer.firstName")
	WebElement firstNameField;

	@FindBy(id = "customer.lastName")
	WebElement lastNameField;

	@FindBy(id = "customer.address.street")
	WebElement addressField;

	@FindBy(id = "customer.address.city")
	WebElement cityField;

	@FindBy(id = "customer.address.state")
	WebElement stateField;

	@FindBy(id = "customer.address.zipCode")
	WebElement zipCodeField;

	@FindBy(id = "customer.phoneNumber")
	WebElement phoneField;

	@FindBy(id = "customer.ssn")
	WebElement ssnField;

	@FindBy(id = "customer.username")
	WebElement usernameField;

	@FindBy(id = "customer.password")
	WebElement passwordField;

	@FindBy(id = "repeatedPassword")
	WebElement confirmPasswordField;

	@FindBy(xpath = "//input[@value='Register']")
	WebElement registerButton;

	@FindBy(id = "customer.username.errors")
	public
	WebElement usernameErrorMessage;


	public void registerCustomer(String firstName, String lastName, String address,
								 String city, String state, String zipCode,
								 String phone, String ssn, String username,
								 String password) {
		//Send Data To The Fields
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		addressField.sendKeys(address);
		cityField.sendKeys(city);
		stateField.sendKeys(state);
		zipCodeField.sendKeys(zipCode);
		phoneField.sendKeys(phone);
		ssnField.sendKeys(ssn);
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(password);
		registerButton.click();
	}


}
