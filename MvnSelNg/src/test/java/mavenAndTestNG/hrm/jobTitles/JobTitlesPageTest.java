package mavenAndTestNG.hrm.jobTitles;
import common.DriverFactory;
import mavenAndTestNG.hrm.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class JobTitlesPageTest {



    // Look at this, created an object of our LoginTests class so I can use the login method we created.
    // But in the future it is not good to create an object of a test class inside another test class.
    // What you should do is utilize POM (Page Object Model) it is our framework design of what we want to have
    // in terms of re-usability

    LoginPage loginPage;
    WebDriver driver;
    String webDriverAddress = "webdriver.chrome.driver";
    String webDriverPath = "src/main/resources/chromedriver.exe";


    /**
     * Scenario: User should be able to add Job Title
     * Given I’m on homepage
     * I click on Admin→ Job → Job Titles
     * I see Add and Delete buttons displayed
     * I can add new Job Title
     * Then newly Added Job Information is displayed in Table.
     */
    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setup(String browserName) throws InterruptedException {
       driver =  DriverFactory.createDriver(browserName);
        loginPage = new LoginPage(driver);
        driver.get("https://dev-hrm.yoll.io");
        driver.manage().window().maximize();
        Thread.sleep(1800);
    }


    // Orkhan said when he is dealing with test cases he likes to use _ format for method names,
    // While having reusable methods use camelCase. It helps understanding at a glance what we're dealing with.

    @Test(groups = {"Smoke"})
    public void user_should_be_able_to_add_job_title() throws InterruptedException{
       loginPage.login("yoll-student", "Bootcamp5#");
        Thread.sleep(2000);

        /* Navigating to job titles page */
        WebElement adminTab = driver.findElement(By.id("menu_admin_viewAdminModule"));
        adminTab.click();
        Thread.sleep(1500);

        WebElement jobSubTab = driver.findElement(By.id("menu_admin_Job"));
        jobSubTab.click();
        Thread.sleep(1500);

        WebElement jobTitlesOption = driver.findElement(By.id("menu_admin_viewJobTitleList"));
        jobTitlesOption.click();
        Thread.sleep(1500);

        /*Verifying if Add and Delete buttons are displayed*/
        WebElement addButton = driver.findElement(By.id("btnAdd"));
        Assert.assertTrue(addButton.isDisplayed());
        WebElement deleteButton = driver.findElement(By.id("btnDelete"));
        Assert.assertTrue(deleteButton.isDisplayed());


        /* Create a job title by filling out the form */
        addButton.click();
        Thread.sleep(1500);
        WebElement jobTitleTextInput = driver.findElement(By.id("jobTitle_jobTitle"));
        jobTitleTextInput.sendKeys("Senior Test Lead");
        Thread.sleep(1500);
        WebElement jobDescriptionTextInput = driver.findElement(By.id("jobTitle_jobDescription"));
        jobDescriptionTextInput.sendKeys("The senior lead of a testing team.");
        Thread.sleep(1500);
        WebElement saveBtn = driver.findElement(By.id("btnSave"));
        saveBtn.click();


        /* Verify the new title is displayed in the table */
        boolean isNewJobTitleDisplayed = false;
        List<WebElement> jobTitles =
                driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a"));

        for(WebElement title : jobTitles){
            String jobTitleValue = title.getText();
            if(jobTitleValue.equals("Senior Test Lead")){
                isNewJobTitleDisplayed = true;
                break;
            }
        }
        Assert.assertTrue(isNewJobTitleDisplayed, "New Job Title verification has failed.");

    }


    /**
     * Scenario: User should be able to remove job title
     * Given I'm on homepage
     * I click on Admin -> Job -> Job Titles
     * I add new Job Title by clicking on add button
     * Then I can remove newly added Job Title
     * Then newly added job title is displayed in Table.
     */

    @Test
    public void verify_delete_from_table_function_is_working() throws InterruptedException {
        loginPage.login("yoll-student", "Bootcamp5#");
        Thread.sleep(2000);

        /* Navigating to job titles page */
        WebElement adminTab = driver.findElement(By.id("menu_admin_viewAdminModule"));
        adminTab.click();
        Thread.sleep(1500);

        WebElement jobSubTab = driver.findElement(By.id("menu_admin_Job"));
        jobSubTab.click();
        Thread.sleep(1500);

        WebElement jobTitlesOption = driver.findElement(By.id("menu_admin_viewJobTitleList"));
        jobTitlesOption.click();
        Thread.sleep(1500);

        /*Verifying if Add and Delete buttons are displayed*/
        WebElement addButton = driver.findElement(By.id("btnAdd"));
        Assert.assertTrue(addButton.isDisplayed());
        WebElement deleteButton = driver.findElement(By.id("btnDelete"));
        Assert.assertTrue(deleteButton.isDisplayed());
        int i = 0;
        List<WebElement> jobTitles =
                driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a"));
        for(WebElement jobTitle : jobTitles){
            String jobTitleValue = jobTitle.getText();
            if(jobTitleValue.contains("SDET")){
                // The lengthy xpath does this:
                // Navigates to the table header with "resultTable"
                // goes to the body, and locates the first column.
                // filters it by [a] tag that contains SDET so that the only elements
                // we grab are the job titles with SDET.
                // We go up 2 elements and then down one to get to the checkbox element, not the whole box.
                // Now the only checkboxes that can be selected are checkboxes that correlate to a job title
                // that contains SDET.
                driver.findElement(By.xpath("(//table[@id='resultTable']/tbody/tr/td/a[contains(text(), 'SDET')]/../..//input)["+i+"]")).click();
                i++;
            }
        }
        //TODO Click on Delete button
        //TODO click on ok button on Confirmation Model Window
        //TODO loop again and verify that Job Title is not displayed on table.



    }






    @AfterClass(alwaysRun = true)
    public void teardown(){
        driver.quit();
    }
}
