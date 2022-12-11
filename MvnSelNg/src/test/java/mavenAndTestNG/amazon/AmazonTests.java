package mavenAndTestNG.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class AmazonTests {

    ChromeDriver driver;
    String webDriverAddress = "webdriver.chrome.driver";
    String webDriverPath = "src/main/resources/chromedriver.exe";


   // previously in Selenium, we had to have a main method to execute our program.
   // Here, we will replace main method with assertions.

    // Assertions work with all primitive data types, and objects. (literally everything)

    // ASSERTIONS
    // assertTrue(boolean condition, "reason why failed")
    // assertFail(boolean condition, "reason why failed")
    // fail("custom message")
    // assertEquals(actual, expected, "error message")
    // assertNotEquals(actual, expected)
    // assertSame(actual, expected)   <-- only compares references of objects, not the value.
    // assertNotSame(actual, expected)<-- also only uses references.


    @BeforeMethod(alwaysRun = true)
    public void setup() throws InterruptedException{
        System.setProperty(webDriverAddress, webDriverPath);
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        Thread.sleep(2500);
        driver.navigate().refresh();
        Thread.sleep(1500);

    }

//    @BeforeMethod
//    public void setup() throws InterruptedException {
//        System.setProperty(webDriverAddress, webDriverPath);
//         driver = new ChromeDriver();
//        driver.get("https://www.amazon.com");
//        Thread.sleep(2500);
//        driver.navigate().refresh();
//        Thread.sleep(1500);
//    }

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }

    public String returnMeSomething(){
        // This is a reusable method, it is not a test because there is no @Test annotation.
        // We can call this method from anywhere in this class, and reuse it as much as we want.

        return null;
    }


        @Test(groups = {"Smoke"})
    public void verifyAmazonLogo() throws InterruptedException {

            driver.get("https://amazon.com");

            driver.manage().window().maximize();
            Thread.sleep(2000);

            WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
            Assert.assertTrue(amazonLogo.isDisplayed(), "Amazon logo verification failed");
        }

















        @Test
    public void verifyAmazonAddress() throws InterruptedException {
            driver.get("https://amazon.com");
            driver.manage().window().maximize();
            Thread.sleep(1200);
           WebElement logIn = driver.findElement(By.id("nav-link-accountList"));
           logIn.click();
           WebElement emailInput = driver.findElement(By.id("ap_email"));
           WebElement submitBtn = driver.findElement(By.id("continue"));
           emailInput.click();
           emailInput.sendKeys("berrydaniel@live.com");
           Thread.sleep(1200);
           submitBtn.click();
           WebElement passwordInput = driver.findElement(By.id("ap_password"));
           WebElement signInBtn = driver.findElement(By.id("signInSubmit"));
           passwordInput.click();
           passwordInput.sendKeys("Why=mx+b");
           Thread.sleep(1200);
           signInBtn.click();
           Thread.sleep(1200);
           WebElement addressBox = driver.findElement(By.id("glow-ingress-line2"));
           Assert.assertTrue(addressBox.getText().contains("Madison 53704"), "The Amazon address verification failed.");
        }


        @Test
    public void verifyAmazonCity(){
            driver.get("https://amazon.com");
            driver.manage().window().maximize();
            WebElement amazonCity = driver.findElement(By.id("glow-ingress-line2"));
            String actualCity = amazonCity.getText();
            String expectedCity = "Select your address";

            /*Asserting with assertTrue*/
//            Assert.assertTrue(actualCity.equals(expectedCity), "The amazon city verification failed.");

            /*Asserting with assertEquals*/
            Assert.assertEquals(actualCity, expectedCity, "Amazon city verification failed!");
        }

        @Test
        public void verify_amazon_city_not_equals() throws InterruptedException {
            driver.get("https://amazon.com");
            driver.manage().window().maximize();
            Thread.sleep(2000);

            WebElement amazonCity = driver.findElement(By.id("glow-ingress-line2"));
            String actualCity = amazonCity.getText();
            String expectedCity = "invalid data for address";

            Assert.assertNotEquals(actualCity, expectedCity, "Address not equal, verification failed!");
        }

        @Test
    public void verify_amazon_title() throws InterruptedException{
            driver.get("https://amazon.com");
            driver.manage().window().maximize();
            Thread.sleep(2000);

            String amazonTitle = driver.getTitle();

            Assert.assertEquals(amazonTitle, "Amazon.com. Spend less. Smile more.", "The title verification has failed.");
        }


        @Test
    public void verify_amazon_city_with_soft_assert() throws InterruptedException {

        WebElement amazonCity = driver.findElement(By.id("glow-ingress-line2"));
        String actualAmazonCity = amazonCity.getText();
        String expectedAmazonCity = "Select your phone";
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(actualAmazonCity, expectedAmazonCity);
            softAssert.assertAll();
        }

        @AfterMethod(alwaysRun = true)
    public void teardown(){
        driver.quit();
        }


}

