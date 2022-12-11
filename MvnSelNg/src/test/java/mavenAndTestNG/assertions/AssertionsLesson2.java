package mavenAndTestNG.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AssertionsLesson2 {

    // Types of Data
    // Configuration level data   <-- setting up drivers, url, username, password, etc.
    // We can make configuration files that hold all of our configuration data.

    // Test Level Data  <-- expectedUserName, actualUserName
    //


    // Verify - Soft Assert

    // Verify and Soft Assert are used basically interchangably.
    // When the interviewer uses "assert" they're talking about hard assertions.
    // Hard assertions: assertTrue, assertFalse, assertEquals, etc.
    // When we use hard assertions an exception will stop the execution of the rest of the @Test method.



    // Soft Assertions
    // Soft Assertions DO NOT throw exeptions when an assert fails, and will continue with the next step
    // after the assert statement.
    //  - If using SoftAssert, you MUST remember to include assertAll() method call at the end, otherwise failed tests
    //      will show as passed.
    // We use soft assert to verify multiple elements, and assertAll() to return the total of all the verified elements.
    // If we use hard for the same thing, then it will stop at the very first failed assertion.
    // With soft assertions we can get a list of all the mismatched elements


    @Test
    public void verifyAmazonCity(){
        String webDriverAddress = "webdriver.chrome.driver";
        String webDriverPath = "src/main/resources/chromedriver.exe";
        System.setProperty(webDriverAddress, webDriverPath);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");
        driver.manage().window().maximize();
        WebElement amazonCity = driver.findElement(By.id("glow-ingress-line2"));
        String actualCity = amazonCity.getText();
        String expectedCity = "Select your address";

        /*Asserting with assertTrue*/
//            Assert.assertTrue(actualCity.equals(expectedCity), "The amazon city verification failed.");

//        /*Asserting with assertEquals*/
//        Assert.assertEquals(actualCity, expectedCity, "Amazon city verification failed!");


        /*Asserting with soft assert*/
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualCity, expectedCity, "Amazon city verification failed!");
        softAssert.assertAll();   // <-- NEEDED ALL THE TIME, IF NOT USED FAILED TESTS WILL SHOW AS PASSED
        driver.quit();

    }


    @Test
    public void verify_elements_on_page() throws InterruptedException {
        String webDriverAddress = "webdriver.chrome.driver";
        String webDriverPath = "src/main/resources/chromedriver.exe";
        System.setProperty(webDriverAddress, webDriverPath);
        ChromeOptions capability = new ChromeOptions();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        WebDriver driver = new ChromeDriver(capability);



        driver.get("https://dev-hrm.yoll.io");
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));

        String userName = "yoll-student";
        String password = "Bootcamp5#";

        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginBtn.click();

        Thread.sleep(2000);
        List<WebElement> allMenuItems = driver.findElements(By.xpath("//ul/li//b"));
        String [] expectedMenuItems = {"Admin", "PIM", "Leave", "Time", "Recruitments", "My Info", "Performances", "Dashboard", "Directory", "Maintenance"};

//        SoftAssert sa = new SoftAssert();

        // We did the verification with Soft Assertion first, and then moved to hard assertions.
        // When we did soft assert, it ran through the whole test case and let us know what elements didn't match.
        // Hard assert stopped at the first thing that didn't match and failed the test case.

        for(int i = 0; i < expectedMenuItems.length; i++){
            Assert.assertEquals(allMenuItems.get(i).getText(), expectedMenuItems[i], "Assertion Failed" );
 //           sa.assertEquals(allMenuItems.get(i).getText(), expectedMenuItems[i], "Assertion Failed" );
        }
 //       sa.assertAll();
        driver.quit();


    }



}
