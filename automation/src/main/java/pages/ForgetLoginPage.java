package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetLoginPage extends PageBase {

    public ForgetLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "title")
    WebElement pageTitle;

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "address.street")
    WebElement addressField;

    @FindBy(id = "address.city")
    WebElement cityField;

    @FindBy(id = "address.state")
    WebElement stateField;

    @FindBy(id = "address.zipCode")
    WebElement zipCodeField;

    @FindBy(id = "ssn")
    WebElement ssnField;

    @FindBy(xpath = "//input[@value='Find My Login Info']")
    WebElement findMyLoginInfoButton;

    @FindBy(xpath = "//h1[@class='title']")
    public
    WebElement errorTitle;

    @FindBy(xpath = "//p[@class='error']")
    public
    WebElement errorMessage;

    public void fillCustomerLookupForm(String firstName, String lastName, String address,
                                       String city, String state, String zipCode, String ssn) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        stateField.sendKeys(state);
        zipCodeField.sendKeys(zipCode);
        ssnField.sendKeys(ssn);
    }

    public void clickFindMyLoginInfo() {
        findMyLoginInfoButton.click();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getLoginTitle() {
        return errorTitle.getText();
    }
    public String getErrorMesageForgetInfo() {
        return errorMessage.getText();
    }
}
