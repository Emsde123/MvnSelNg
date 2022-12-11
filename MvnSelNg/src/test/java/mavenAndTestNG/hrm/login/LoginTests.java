package mavenAndTestNG.hrm.login;

import common.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests {
  WebDriver driver;


    LoginPage loginPage;
//    public void login(String username, String password){
//        WebElement usernameField = driver.findElement(By.id("txtUsername"));
//        WebElement passwordField = driver.findElement(By.id("txtPassword"));
//        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
//        usernameField.clear();
//        passwordField.clear();
//        usernameField.sendKeys(username);
//        passwordField.sendKeys(password);
//        loginBtn.click();
//    }

//    public void verifyUserMessage(String expectedErrorMessage){
//        WebElement errorMessage = driver.findElement(By.id("spanMessage"));
//        String actualErrorMessage = errorMessage.getText();
//        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error message validation has failed");
//    }

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setup(String browserName) throws InterruptedException {
        driver = DriverFactory.createDriver(browserName);
        loginPage = new LoginPage(driver);
        driver.get("https://dev-hrm.yoll.io");
        driver.manage().window().maximize();
        Thread.sleep(1800);
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        driver.quit();
    }


    // DataProvider needs us to return a multi-dimensional array.
    // Now if we want to add more negative tests to our test set, we can just add the data to this multi-array.
    // We should not have any test data present inside of Test cases if it's possible.
//    @DataProvider(name = "credentials")
//    public Object [][] getCredentialsAndErrorMessage(){
//        return new Object[][]{
//                {"yoll-student12345", "Bootcamp5###", "Invalid credentials"},
//                {"", "Bootcamp5#####", "Username cannot be empty"},
//                {"yoll-student", "", "Password cannot be empty"},
//                {"", "", "Username cannot be empty"}
//        };
//    }

    // Now I have 2 test annotations, while having 5 test scenarios/cases in total.

    @Test(dataProvider = "credentials", dataProviderClass = LoginPageData.class, groups = {"Smoke"}, enabled = true)
    public void verify_user_is_not_able_to_login_invalid_credentials(String username, String password, String errorMessage) throws InterruptedException{
        /*Calling login method*/
        loginPage.login(username,password);
        /*Calling error message verification method*/
        loginPage.verifyUserMessage(errorMessage);
    }






    @Test( enabled = true, groups = {"Smoke"}, priority = 2)
    public void test_Login_Functionality_Is_Working() throws InterruptedException {
        String expectedUserName = "Welcome ggg";
        loginPage.login("yoll-student", "Bootcamp5#");
        String accountUserNameDisplayed = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(accountUserNameDisplayed, expectedUserName);
        driver.navigate().back();
    }






//
//    @Test(priority = 2)
//    public void verify_user_is_not_able_to_login_with_invalid_credentials() throws InterruptedException {
//
//        login("yoll-student12345", "Bootcamp5####");
//        Thread.sleep(1500);
//       verifyUserMessage("Invalid credentials");
//    }
//
//    @Test(priority = 2)
//    public void verify_user_is_not_able_to_login_with_empty_username() throws InterruptedException {
//        Thread.sleep(1500);
//        login("", "bootcamp***");
//        Thread.sleep(1500);
//        verifyUserMessage("Username cannot be empty");
//
//    }
//        @Test(priority = 2)
//    public void verify_user_is_not_able_to_login_with_empty_password() throws InterruptedException {
//        login("Emsde123", "");
//            Thread.sleep(1500);
//        verifyUserMessage("Password cannot be empty");
//            Thread.sleep(1500);
//
//    }
//
//    @Test(priority = 2)
//    public void verify_user_is_not_able_to_login_with_empty_credentials() throws InterruptedException {
//        Thread.sleep(1500);
//        login("", "");
//        Thread.sleep(1500);
//        verifyUserMessage("Username cannot be empty");
//
//    }









}
