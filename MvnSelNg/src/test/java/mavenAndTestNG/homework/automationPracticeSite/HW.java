package mavenAndTestNG.homework.automationPracticeSite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HW {
    WebDriver driver;
    String webDriverAddress = "webdriver.chrome.driver";
    String webDriverPath = "src/main/resources/chromedriver.exe";

    @BeforeMethod
    public void setup(){
        System.setProperty(webDriverAddress, webDriverPath);
        ChromeOptions capability = new ChromeOptions();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        driver = new ChromeDriver(capability);
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
    }


    @Test
    public void remove_all_letters_except_the_first_from_firstName() throws InterruptedException {
        String myName = "Daniel";
        WebElement firstName = driver.findElement(By.xpath("//input[@ng-model='FirstName']"));
        firstName.sendKeys(myName);
        for(int i = 0; i < myName.length() - 1; i++){
            firstName.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(500);
        }

    }


    @Test
    public void print_options_for_month_dropdown(){
        WebElement monthDropdown = driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
        List<WebElement> months =
                driver.findElements(By.xpath("//select[@ng-model='monthbox']/option"));
        monthDropdown.click();
        for(int i = 1; i <= 12; i++){
            System.out.println(months.get(i).getText());
        }

    }

    @Test
    public void print_all_skills_until_email(){
        WebElement skillsDropdown = driver.findElement(By.xpath("//select[@ng-model='Skill']"));
        skillsDropdown.click();
        List<WebElement> skills =
                driver.findElements(By.xpath("//select[@ng-model='Skill']/option"));
        for(WebElement allSkills : skills){

            if(!allSkills.getText().equals("Email")){
                System.out.println(allSkills.getText());
            }else{
                System.out.println(allSkills.getText());
                break;
            }

        }

     }






    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
