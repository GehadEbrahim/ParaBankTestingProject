package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs_Page extends PageBase {

    public ContactUs_Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "name")
    WebElement nameField;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "phone")
    WebElement phoneField;

    @FindBy(name = "message")
    WebElement messageField;

    @FindBy(css = "input[type='submit']")
    WebElement submitButton;

    @FindBy(css = "h1.title")
    WebElement pageTitle;

    @FindBy(css = "#rightPanel p:nth-child(2)")
    WebElement thankYouMessage;

    @FindBy(css = "#rightPanel p:nth-child(3)")
    WebElement confirmationMessage;

    public void fillContactForm(String name, String email, String phone, String message) {
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        phoneField.sendKeys(phone);
        messageField.sendKeys(message);
    }

    public void submitContactForm() {
        submitButton.click();
    }

    public String getThankYouMessage() {
        return thankYouMessage.getText();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }


    public String getPageTitle() {
        return pageTitle.getText();
    }

}
