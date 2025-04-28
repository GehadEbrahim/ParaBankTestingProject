package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OpenNewAcc_Page extends PageBase {
    public OpenNewAcc_Page(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(css = "#leftPanel > ul > li:nth-child(1) > a")
    WebElement openNewAccPageBtn;
    
    @FindBy(id = "type")
    WebElement accountDropDownList;

    @FindBy(id = "fromAccountId")
    WebElement accountIdDropDownList;
    
    @FindBy(css = "#openAccountForm > form > div > input")
    WebElement openNewAccSubmitBtn;
    
    @FindBy(css = "#openAccountResult > p:nth-child(2)")
    public WebElement congratesMessage;
    
    public void openNewAccountPage() {
        openNewAccPageBtn.click();
    }
    
    public void openNewAccSubmit() {
    	openNewAccSubmitBtn.click();
    }
    public void selectCheckingAccount() {
        Select accountType = new Select(accountDropDownList);
        accountType.selectByIndex(0);
        Assert.assertEquals(accountType.getFirstSelectedOption().getText(), "CHECKING");
    }
    
    public void selectSavingsAccount() {
        Select accountType = new Select(accountDropDownList);
        accountType.selectByVisibleText("SAVINGS");
        Assert.assertEquals(accountType.getFirstSelectedOption().getText(), "SAVINGS");
    }
    
    public void verifyAccountIdIsNumeric() {
        Select accountId = new Select(accountIdDropDownList);
        List<WebElement> options = accountId.getOptions();
        String firstAccountId = options.get(0).getText();
        Assert.assertTrue(firstAccountId.matches("\\d+"));
    }
}