package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BillPay_Page extends PageBase {

	public BillPay_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Bill Pay")
	WebElement billPayPageBtn;

	@FindBy(name = "payee.name")
	WebElement payeeNameField;

	@FindBy(name = "payee.address.street")
	WebElement AddressField;

	@FindBy(name = "payee.address.city")
	WebElement cityField;

	@FindBy(name = "payee.address.state")
	WebElement stateField;

	@FindBy(name = "payee.address.zipCode")
	WebElement zipCodeField;

	@FindBy(name = "payee.phoneNumber")
	WebElement phoneNumberField;

	@FindBy(name = "payee.accountNumber")
	WebElement accountNumberField;

	@FindBy(name = "verifyAccount")
	WebElement verifyAccountField;

	@FindBy(name = "amount")
	WebElement amountField;

	@FindBy(name = "fromAccountId")
	WebElement fromAccountIdDropList;

	@FindBy(css ="#billpayForm > form > table > tbody > tr:nth-child(14) > td:nth-child(2) > input")
	WebElement sendPaymentBtn;

	@FindBy(css = "#billpayResult > h1")
	public WebElement paymentSuccessMessage;

	@FindBy(id = "validationModel-account-invalid")
	public WebElement invalidDataMessage;

	public void openBillPay_Page() {
		billPayPageBtn.click();
	}

	public void fillBillPayForm(String name , String street, String city , String state, String zipCode , String phoneNumber
			, String accNum , String verifyAccNum , String amount) {

		payeeNameField.sendKeys(name);
		AddressField.sendKeys(street);
		cityField.sendKeys(city);
		stateField.sendKeys(state);
		zipCodeField.sendKeys(zipCode);
		phoneNumberField.sendKeys(phoneNumber);
		accountNumberField.sendKeys(accNum);
		verifyAccountField.sendKeys(verifyAccNum);
		amountField.sendKeys(amount);

		Select fromAccountId = new Select(fromAccountIdDropList);
		List<WebElement> fromAccountIdDropList = fromAccountId.getOptions();
		String fromAccountIdChoice;
		if(fromAccountIdDropList.size() > 2) {
			fromAccountIdChoice = fromAccountIdDropList.get(1).getText();
		}
		else {
			fromAccountIdChoice = fromAccountIdDropList.get(0).getText();
		}
		Assert.assertTrue(fromAccountIdChoice.matches("\\d+"));
	}

	public void sendPaymentSubmit() {
		sendPaymentBtn.click();
	}
}
