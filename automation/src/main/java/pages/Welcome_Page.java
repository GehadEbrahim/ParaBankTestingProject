package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TransferFunds_Page extends PageBase{

	public TransferFunds_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Transfer Funds")
	WebElement transferFundsPageBtn;

	@FindBy(id = "amount")
	WebElement amountFild;


	@FindBy(id = "fromAccountId")
	WebElement fromAccountDropList;

	@FindBy(id = "toAccountId")
	WebElement toAccountDropList;

	@FindBy(css = "#transferForm > div:nth-child(4) > input")
	WebElement transferBtn;

	@FindBy(css ="#showResult > h1")
	public WebElement transferCompleteMessage;

	@FindBy(id = "showError")
	public WebElement errorTransferFunds;

	public void openTransferFundsPage() {
		transferFundsPageBtn.click();
	}

	public void userCanEnterAmountOfMoney(String amount) {
		amountFild.sendKeys(amount);

	}

	public void selectFromAccountID() {
		Select fromAccountId = new Select(fromAccountDropList);
		List<WebElement> fromAccountList = 	fromAccountId.getOptions();
		String fromAccountIdChoice;
		if(fromAccountList.size() > 2) {
			fromAccountIdChoice = fromAccountList.get(1).getText();
		}
		else {
			fromAccountIdChoice = fromAccountList.get(0).getText();
		}
		Assert.assertTrue(fromAccountIdChoice.matches("\\d+"));
	}

	public void selectToAccountID() {
		Select toAccountId = new Select(toAccountDropList);
		List<WebElement> toAccountList = toAccountId.getOptions();
		String toAccountIdChoice;
		if(toAccountList.size() > 2) {
			toAccountIdChoice = toAccountList.get(1).getText();
		}
		else {
			toAccountIdChoice = toAccountList.get(0).getText();
		}
		Assert.assertTrue(toAccountIdChoice.matches("\\d+"));
	}

	public void transferSubmit(){
		transferBtn.click();
	}

}
