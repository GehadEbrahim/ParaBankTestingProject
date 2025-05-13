package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class OpenNewAcc_Page extends PageBase {
    public OpenNewAcc_Page(WebDriver driver) {
        super(driver);
    }

    Login_Page loginPage = new Login_Page(driver);
    Home_Page homePage = new Home_Page(driver);

    @FindBy(css = "#leftPanel > ul > li:nth-child(1) > a")
    WebElement openNewAccPageBtn;

    @FindBy(id = "type")
    WebElement accountDropDownList;

    @FindBy(id = "fromAccountId")
    WebElement accountIdDropDownList;

    @FindBy(css = "#openAccountForm > form > div > input")
    WebElement openNewAccSubmitBtn;

    @FindBy(css = "#openAccountResult > h1")
    public WebElement congratesMessage;


    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));

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
    public boolean isLoggedIn(String name, String pass) throws InterruptedException {
        loginPage.login(name, pass);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#leftPanel > p > b")));
        } catch (Exception e) {
            System.out.println("Element not found: Welcome message is missing.");
            return false;
        }
        if (homePage.getWelcomeMessageText().contains("Welcome")) {
            return true;
        } else {
            return false;
        }
    }
}