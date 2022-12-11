package mavenAndTestNG.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HW {




        @Test
    public void fill_out_form() {
            String webDriverAddress = "webdriver.chrome.driver";
            String webDriverPath = "src/main/resources/chromedriver.exe";
            System.setProperty(webDriverAddress, webDriverPath);
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://demo.guru99.com/test/newtours/");
            driver.manage().window().maximize();

            WebElement flightsBtn = driver.findElement(By.xpath("//a[text()='Flights']"));
            flightsBtn.click();
            WebElement passengerDropDown = driver.findElement(By.xpath("//select[@name='passCount']"));
            passengerDropDown.click();
            driver.findElement(By.xpath("//select[@name='passCount']//option[@value='2']")).click();






        }





}
