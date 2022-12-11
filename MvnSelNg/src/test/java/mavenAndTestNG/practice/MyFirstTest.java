package mavenAndTestNG.practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyFirstTest {
    public static void main(String[] args) {
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//          BASIC WAY TO FIND IF AN ELEMENT IS PRESENT
//        Select dropdown = new Select(dropdownElement);
//        List<WebElement> allElements = dropdown.getOptions();
//        boolean presenceOfElement = false;
//        for(WebElement element : allElements){
//            String dropdownOptionValue = element.getText();
//            if(dropdownOptionValue.equals("Salem")){
//                presenceOfElement = true;
//            }
//        }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                     RECAP
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        driver.get("https://demo.automationtesting.in/Register.html");
//        driver.quit();
//
//        WebElement skillsDropdownElement = driver.findElement(By.id("Skills"));
//
//        /* Create an object from Select class by passing "skillsDropdownElement as a parameter */
//       /* Creating an object of select class expects you to pass our element */
//         Select skillsDropdown = new Select(skillsDropdownElement);
//
//         String mySkill = "HTML";  // <-- We're using this String to help make our code more dynamic.
//        // We don't have to change the HTML skill from inside our implementation, we can just update
//        // the String value from anywhere it's stored.
//
//        boolean isOptionPresent = false;   // <-- we can use this to verify things
//
//
//            /* Grab a list of all our options for dropdown */
//    /* We use .getOptions method to interact with the Select object we created (getOptions belongs to Select class) */
//          List<WebElement> allSkillsOptions = skillsDropdown.getOptions();
//
//
//        /* Print all skills on console */
//        for(WebElement skill : allSkillsOptions){
//            String skillOptionValue = skill.getText();
//            System.out.println(skillOptionValue);
//
//            if(skillOptionValue.equals("HTML")){
//                isOptionPresent = true;
//                break;
//            }
//        }
//        System.out.println("Is your option present? " + isOptionPresent); // <-- this line will be replaced by assertions.
//
//
////-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
////                      Find weather an element is selected using .isSelected() method
//        // boolean selectedOrNot = optionElement.isSelected();
//
//        boolean isOptionSelected = skillsDropdown.getFirstSelectedOption().isSelected();
//        System.out.println("Is any option selected: " + isOptionSelected);
//
//        String selectedSkill = skillsDropdown.getFirstSelectedOption().getText();
//        System.out.println("My first selected option is: " + selectedSkill);
//        driver.quit();
//////-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        // Using the same data in different ways
//        // Say we have the String skillOptionValue, it has a value of HTML. We can use that to enter HTML as our selected skill through selenium,
//        // And then we can use that same data to perform an assertion and verify that the correct info was passed/selected.
////-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        //              Multiple Dropdowns
//        // We have a method that is specific to multi dropdowns, that is
//        // myObj.deselectAll();
//        // which will unselect all the values from the multidrop down.
//        // We can use all the methods in the Select class to interact with multivalue dropdowns,
//        // as long as they are defined with select tags in HTML
////-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



    }
}
