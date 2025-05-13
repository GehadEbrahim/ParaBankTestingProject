package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends PageBase{

    public Home_Page(WebDriver driver) {
        super(driver);

    }
    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(css = "p.smallText")
    WebElement welcomeMessage;

    @FindBy(css = "#loginPanel > form > div:nth-child(5) > input")
    WebElement logInBtn;

    @FindBy(linkText = "Forgot login info?")
    public
    WebElement forgotLoginLink;

    @FindBy(linkText = "Contact Us")
    WebElement contactUsLink;


    public void clickRegisterLink() {
        registerLink.click();
    }
    public String getWelcomeMessageText() {
        return welcomeMessage.getText();
    }
    public boolean isWelcomeMessageContains(String text) {
        return getWelcomeMessageText().contains(text);
    }
    public void clickLogIn() {
        logInBtn.click();
    }
    public void clickContactUsLink() {
        contactUsLink.click();
    }

}
