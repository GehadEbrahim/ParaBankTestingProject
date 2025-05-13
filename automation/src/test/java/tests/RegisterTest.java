package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Home_Page;
import pages.Register_Page;
import pages.Login_Page;

public class RegisterTest extends TestBase {

    Login_Page loginPage = new Login_Page(driver);
    @DataProvider(name ="RegisterHappyData")
    public Object[][] registerTestData(){
        Object[][] data = new Object[][] {
                {"Menna","Helmy","123 Main St","Anytown","CA","90210","555-123-4567","123-45-6789","Mena", "0"},
                {"Gehad","Ebrahim","123 Main St","Anytown","CA","90210","555-123-4567","123-45-6789","Gehad","0"}};
        return data ;
    }
    @Test(priority = 1 , dataProvider = "RegisterHappyData")
    public void testSuccessfulRegistration(String firstName, String lastName, String address,
                                           String city, String state, String zipCode,
                                           String phone, String ssn, String username,
                                           String password) throws InterruptedException {

        Home_Page homePage = new Home_Page(driver);
        homePage.clickRegisterLink();
        Register_Page registerPage = new Register_Page(driver);

        Assert.assertEquals(Register_Page.pageTitle.getText(), "Signing up is easy!");

        registerPage.registerCustomer(firstName , lastName , address , city ,
                state , zipCode , phone , ssn, username , password);
        Thread.sleep(1000);
        Assert.assertTrue(homePage.getWelcomeMessageText().contains("Welcome"));
        loginPage.logout();
    }


}