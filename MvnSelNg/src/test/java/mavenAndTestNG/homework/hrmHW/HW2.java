package mavenAndTestNG.homework.hrmHW;

import mavenAndTestNG.hrm.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class HW2 {

    LoginPage loginPage;
    WebDriver driver;

   String username = "yoll-student";
   String password = "Bootcamp5#";




    @BeforeMethod
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions capability = new ChromeOptions();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        driver = new ChromeDriver(capability);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.get("https://dev-hrm.yoll.io/index.php/auth/login");
        Thread.sleep(1500);
    }

    String firstName = "Daniel";
    String middleName = "William";
    String lastName = "Berry";

    @Test
    public void admin_Should_Be_Able_To_Add_New_Employee() throws InterruptedException {
        loginPage.login(username, password);
        // Creating the employee record
        WebElement pimBtn = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimBtn.click();

        Thread.sleep(2000);
        WebElement addEmployeeBtn = driver.findElement(By.id("menu_pim_addEmployee"));
        addEmployeeBtn.click();

        WebElement firstNameBox = driver.findElement(By.id("firstName"));
        firstNameBox.sendKeys(firstName);

        WebElement middleNameBox = driver.findElement(By.id("middleName"));
        middleNameBox.sendKeys(middleName);

        WebElement lastNameBox = driver.findElement(By.id("lastName"));
        lastNameBox.sendKeys(lastName);

        // Making sure there is an employee number.
        WebElement empID = driver.findElement(By.id("employeeId"));
        String empIDValue = (empID.getAttribute("value"));
        Assert.assertFalse(empIDValue == null);

        WebElement saveBtn = driver.findElement(By.id("btnSave"));
        saveBtn.click();

        // Verifying the information is correct
        WebElement empList = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        empList.click();

        List<WebElement> empFirstNameTableColumn = driver.findElements(By.xpath("//tbody/tr/td[3]/a"));
        List<WebElement> empLastNameTableColumn = driver.findElements(By.xpath("//tbody/tr/td[4]/a"));
        String firstNameCheck = "";
        String lastNameCheck = "";
        for(WebElement firstNames : empFirstNameTableColumn){
            if(firstNames.getText().equals(firstName + " " + middleName)){
                firstNameCheck += firstNames.getText();
                break;
            }
        }
        for(WebElement lastNames : empLastNameTableColumn){
            if(lastNames.getText().equals(lastName)){
                lastNameCheck += lastNames.getText();
                break;
            }
        }
        Assert.assertEquals(firstNameCheck, firstName + " " + middleName);
        Assert.assertEquals(lastNameCheck, lastName);

    }


    @Test
    public void user_Is_Able_To_Logout_Successfully() throws InterruptedException {
        loginPage.login("yoll-student", "Bootcamp5#");
        WebElement accountBtn = driver.findElement(By.id("welcome"));
        accountBtn.click();
        Thread.sleep(1000);

        WebElement logoutBtn = driver.findElement(By.xpath("//a[text()='Logout']"));
        logoutBtn.click();
       Assert.assertTrue(loginPage.usernameField.isDisplayed(), "Login page validation has failed.");
    }
    //a[@id='menu_admin_Job']/following-sibling::ul/li/a[@id='menu_admin_viewJobTitleList']
    /*    Given I’m on the homepage
    I click on Admin→ Job → Job Titles
    I added to add new Job Title by clicking on add button
    Then I can remove the newly added Job Title*/

    @Test
    public void delete_Job_Title_Successfully() throws InterruptedException {
        loginPage.login("yoll-student", "Bootcamp5#");
        Thread.sleep(1000);

        WebElement adminModule = driver.findElement(By.id("menu_admin_viewAdminModule"));
        adminModule.click();
//
       WebElement jobModule = driver.findElement(By.id("menu_admin_Job"));
        Actions mouseOver = new Actions(driver);
        mouseOver.moveToElement(jobModule).build().perform();


        Thread.sleep(1000);
        WebElement jobList = driver.findElement(By.id("menu_admin_viewJobTitleList"));
        jobList.click();

        WebElement addBtn = driver.findElement(By.id("btnAdd"));
        addBtn.click();

        WebElement jobTitle = driver.findElement(By.id("jobTitle_jobTitle"));
        jobTitle.sendKeys("Plumber");

        WebElement jobDesc = driver.findElement(By.id("jobTitle_jobDescription"));
        jobDesc.sendKeys("I plumb");
        Thread.sleep(1500);

        WebElement saveBtn = driver.findElement(By.id("btnSave"));
        saveBtn.click();
        Thread.sleep(1500);


        WebElement jobToBeDeleted = driver.findElement(By.xpath("//a[text()='Plumber']/../..//input"));
        jobToBeDeleted.click();

        WebElement deleteBtn = driver.findElement(By.id("btnDelete"));
        deleteBtn.click();

        WebElement areYouSureBtn = driver.findElement(By.id("dialogDeleteBtn"));
        areYouSureBtn.click();

        List<WebElement> jobTitleRemovalCheck = new ArrayList<>(driver.findElements(By.xpath("//a[text()='Plumber']/../..//input")));
        Assert.assertTrue(jobTitleRemovalCheck.size() == 0,  "The deletion validation has failed.");

    }


    @Test(dataProvider = "credentials", dataProviderClass = HW2Data.class)
    public void user_should_not_be_able_to_login_invalid_credentials(String username, String password, String errorMessage){
        loginPage.login(username, password);
        loginPage.verifyUserMessage(errorMessage);
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
