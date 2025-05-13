package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends PageBase{
    
    public AdminPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

    @FindBy(css = "#headerPanel > ul.leftmenu > li:nth-child(6) > a")
    WebElement OpenAdminPageBtn;
	private By databaseUrlField = By.name("dbUrl");
    private By databaseUserField = By.name("dbUser");
    private By databasePasswordField = By.name("dbPassword");


    private By jmsEnableCheckbox = By.name("enableJms");
    private By jmsBrokerUrlField = By.name("jmsBrokerUrl");


    private By restJsonRadio = By.xpath("//input[@name='dataMode' and @value='REST_JSON']");
    private By soapXmlRadio = By.xpath("//input[@name='dataMode' and @value='SOAP_XML']");


    private By webServiceEndpointField = By.name("webServiceUrl");

    private By initBalanceField = By.name("initBalance");
    private By minBalanceField = By.name("minBalance");

    private By submitButton = By.xpath("//input[@type='submit']");


    public void OpenAdminPage() {
    	OpenAdminPageBtn.click();
    }
	public void setDatabase(String url, String user, String password) {
        driver.findElement(databaseUrlField).clear();
        driver.findElement(databaseUrlField).sendKeys(url);
        driver.findElement(databaseUserField).clear();
        driver.findElement(databaseUserField).sendKeys(user);
        driver.findElement(databasePasswordField).clear();
        driver.findElement(databasePasswordField).sendKeys(password);
    }


    public void enableJmsService(boolean enable, String brokerUrl) {
        if (enable) {
            if (!driver.findElement(jmsEnableCheckbox).isSelected()) {
                driver.findElement(jmsEnableCheckbox).click();
            }
            driver.findElement(jmsBrokerUrlField).clear();
            driver.findElement(jmsBrokerUrlField).sendKeys(brokerUrl);
        } else {
            if (driver.findElement(jmsEnableCheckbox).isSelected()) {
                driver.findElement(jmsEnableCheckbox).click();
            }
        }
    }


    public void selectDataAccessMode(String mode) {
        if (mode.equalsIgnoreCase("REST_JSON")) {
            driver.findElement(restJsonRadio).click();
        } else if (mode.equalsIgnoreCase("SOAP_XML")) {
            driver.findElement(soapXmlRadio).click();
        }
    }


    public void setWebServiceEndpoint(String url) {
        driver.findElement(webServiceEndpointField).clear();
        driver.findElement(webServiceEndpointField).sendKeys(url);
    }


    public void setApplicationSettings(String initBalance, String minBalance) {
        driver.findElement(initBalanceField).clear();
        driver.findElement(initBalanceField).sendKeys(initBalance);
        driver.findElement(minBalanceField).clear();
        driver.findElement(minBalanceField).sendKeys(minBalance);
    }


    public void submitSettings() {
        driver.findElement(submitButton).click();
    }
}