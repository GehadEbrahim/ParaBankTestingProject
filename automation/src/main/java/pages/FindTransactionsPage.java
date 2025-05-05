package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class FindTransactionsPage extends PageBase{
	
	public FindTransactionsPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "a[href='findtrans.htm']")
	WebElement findTransactionsPageBtn;

	// Account ID
	@FindBy(id="accountId")
	WebElement accountIdField;
	
	// Transaction ID
	@FindBy(id="transactionId")
	WebElement transactionIdField;
	
	@FindBy(id="findById")
	WebElement findByIdBtn;
	
	@FindBy(id = "transactionIdError")
	WebElement transactionIdErrorMsg;	
	
	// Transaction Date
	@FindBy(id="transactionDate")
	WebElement transactionDateField;
	
	@FindBy(id="findByDate")
	WebElement findByDateBtn;
	
	@FindBy(id = "transactionDateError")
	WebElement transactionDateErrorMsg;
	
    @FindBy(how = How.CSS, using = "h1.title")
    WebElement transactionResultsTitle;
	
	// Date Range
	@FindBy(id="fromDate")
	WebElement fromDateField;
	
	@FindBy(id="toDate")
	WebElement toDateField; 
	
	@FindBy(id="findByDateRange")
	WebElement findByDateRangeBtn;
	
	@FindBy(id = "dateRangeError")
	WebElement dateRangeErrorMsg;
	
	// Amount
	@FindBy(id="amount")
	WebElement amountField;
	
	@FindBy(id="findByAmount")
	WebElement findByAmountBtn;
	
	@FindBy(id = "amountError")
	WebElement amountErrorMsg;
	
	public void open(){
		findTransactionsPageBtn.click();
	}
	
	public void selectAccountId(String accountId)
	{
	    Select accountDropdown = new Select(accountIdField);
	    accountDropdown.selectByVisibleText(accountId);
	}
	
	void findByTransactionId(String transactionId){
		transactionIdField.clear();
		transactionIdField.sendKeys(transactionId);
	}
	
	public String getTransactionIdErrorMsg() {
	    return transactionIdErrorMsg.getText();
	}

	public void clickTransactionIdBtn() {
		findByIdBtn.click();
	}
	
	public void findByDate(String date){
		transactionDateField.clear();
		transactionDateField.sendKeys(date);
	}
	
	public String getDateErrorMsg() {
	    return transactionDateErrorMsg.getText();
	}
	
	public void clickDateBtn() {
		findByDateBtn.click();
	}
	
    public boolean isTransactionResultsTitleDisplayed() {
        return transactionResultsTitle.isDisplayed();
    }

    // Method to get the text of the title
    public String getTransactionResultsTitleText() {
        return transactionResultsTitle.getText();
    }
	
	public void findByDateRange(String fromDate, String toDate){
		fromDateField.clear();
		fromDateField.sendKeys(fromDate);
		
		toDateField.clear();
		toDateField.sendKeys(toDate);		
	}
	
	public String getDateRangeErrorMsg() {
	    return dateRangeErrorMsg.getText();
	}
	
	public void clickDateRangeBtn() {
		findByDateRangeBtn.click();
	}

		
	public void findByAmount(String amount){
		amountField.clear();
		amountField.sendKeys(amount);
	}
	

	public String getAmountErrorMsg() {
	    return amountErrorMsg.getText();
	}
	
	public void clickAmountBtn() {
		findByAmountBtn.click();
	}
}
