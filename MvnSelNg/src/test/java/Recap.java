import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Recap {
//            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//    WebDriver driver = new ChromeDriver();
//
//        driver.get("https://demo.automationtesting.in/Register.html");
//        Thread.sleep(1000);
//
//    /* Locating skills dropdown */
//    WebElement skillsDropdownElement = driver.findElement(By.id("Skills"));
//
//    /* Create an object from Select class by passing "skillsDropdownElement as a parameter */
//    /* Creating an object of select class expects you to pass our element */
//    Select skillsDropdown = new Select(skillsDropdownElement);
//
//
//    /* Grab a list of all our options for dropdown */
//    /* We use .getOptions method to interact with the Select object we created (getOptions belongs to Select class) */
//    List<WebElement> allSkillsOptions = skillsDropdown.getOptions();
//
//
//        for(WebElement skills : allSkillsOptions){
//        /* If we don't use the .getText method it will just print the actual WebElement */
//        /* But by using .getText it will print the freetext of each element. */
//        System.out.println(skills.getText());
//    }
//
//    /* Now we have to select what skill option we would like to choose. */
//
//    /* Selecting skill option using free text */
//        skillsDropdown.selectByVisibleText("HTML");
//        Thread.sleep(3000);
//
//    /* Selecting skill option using attribute text */
//        skillsDropdown.selectByValue("SQL");
//        Thread.sleep(1500);
//
//    /* Selecting skill option using index */
//        skillsDropdown.selectByIndex(10);
//        Thread.sleep(1500);
//
//        driver.quit();
////-------------------------------------------------------------------------------------------------------------------------------------------------------------
//    // Pointing selenium to where our driver location is
//    // System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//
//    // Instantiating an object of ChromeDriver
//    // WebDriver driver = new ChromeDriver();
//
//        driver.get("https://demo.automationtesting.in/Register.html");
//    // Freezes execution for the specified amount of time
//        Thread.sleep(500);
//
//    /* Locating first name input box */
//    WebElement firstName = driver.findElement(By.xpath("//input[@ng-model='FirstName']"));
//
//    /* Sending keys to the firstName element by using the variable we assigned the xpath to */
//        firstName.sendKeys("Daniel");
//        Thread.sleep(1000);
//
//    // On the next step, you need to understand where we're tabbing from. The source of where we tab from is important.
//    // Look at what happened, we tabbed off the firstName element, and we know the next
//    // Element that will be tabbed to is the lastName box, we can tab from firstName and enter the last name
//    // All in one line.
//        firstName.sendKeys(Keys.TAB, "Berry");
//        Thread.sleep(1000);
//
//        driver.quit();
////--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//    // Click on "Male" checkbox, and "Hockey" checkbox, then close driver.
//
//    //  System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//    //  WebDriver driver = new ChromeDriver();
//        driver.get("https://demo.automationtesting.in/Register.html");
//
//
//    WebElement maleCheckBox = driver.findElement(By.xpath("//input[@value='Male']"));
//
//    List<WebElement> allHobbies = driver.findElements(By.xpath("//*[text()='Hobbies']/..//input"));
//
//
//        allHobbies.get(0).click();
//        allHobbies.get(2).click();
//        maleCheckBox.click();
//
//
//        Thread.sleep(1000);
//        driver.quit();
}
