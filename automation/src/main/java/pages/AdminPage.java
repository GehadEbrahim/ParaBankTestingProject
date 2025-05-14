package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
    private WebDriver driver;

    private By restJsonRadio = By.xpath("//input[@name='dataMode' and @value='REST_JSON']");
    private By restXmlRadio = By.xpath("//input[@name='dataMode' and @value='SOAP_XML']");
    private By soapRadio = By.xpath("//input[@name='dataMode' and @value='SOAP']");
    private By jdbcRadio = By.xpath("//input[@name='dataMode' and @value='JDBC']");

    private By soapEndpointField = By.name("soapEndpoint");
    private By restEndpointField = By.name("restEndpoint");
    private By loanProcessorEndpointField = By.name("loanProcessorEndpoint");

    private By initBalanceField = By.name("initialBalance");
    private By minBalanceField = By.name("minimumBalance");
    private By loanProviderDropdown = By.name("loanProvider");
    private By loanProcessorDropdown = By.name("loanProcessor");
    private By thresholdField = By.name("loanThreshold");

    private By submitButton = By.xpath("//input[@type='submit']");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDataAccessMode(String mode) {
        switch (mode.toUpperCase()) {
            case "SOAP":
                driver.findElement(soapRadio).click();
                break;
            case "REST_XML":
                driver.findElement(restXmlRadio).click();
                break;
            case "REST_JSON":
                driver.findElement(restJsonRadio).click();
                break;
            case "JDBC":
                driver.findElement(jdbcRadio).click();
                break;
        }
    }

    public void setWebServiceEndpoints(String soapUrl, String restUrl, String loanProcessorUrl) {
        driver.findElement(soapEndpointField).clear();
        driver.findElement(soapEndpointField).sendKeys(soapUrl);
        driver.findElement(restEndpointField).clear();
        driver.findElement(restEndpointField).sendKeys(restUrl);
        driver.findElement(loanProcessorEndpointField).clear();
        driver.findElement(loanProcessorEndpointField).sendKeys(loanProcessorUrl);
    }

    public void setApplicationSettings(String initBalance, String minBalance, String loanProvider,
                                       String loanProcessor, String threshold) {
        driver.findElement(initBalanceField).clear();
        driver.findElement(initBalanceField).sendKeys(initBalance);
        driver.findElement(minBalanceField).clear();
        driver.findElement(minBalanceField).sendKeys(minBalance);
        new Select(driver.findElement(loanProviderDropdown)).selectByVisibleText(loanProvider);
        new Select(driver.findElement(loanProcessorDropdown)).selectByVisibleText(loanProcessor);
        driver.findElement(thresholdField).clear();
        driver.findElement(thresholdField).sendKeys(threshold);
    }

    public void submitSettings() {
        driver.findElement(submitButton).click();
    }
}