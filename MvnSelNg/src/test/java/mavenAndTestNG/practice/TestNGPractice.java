package mavenAndTestNG.practice;

public class TestNGPractice {

    // In Selenium, methods are test cases and Classes are a group of test cases.
    // We can hold a lot of test cases that are related inside of one class.
    // For example, if we're testing the Amazon homepage we can have a class dedicated to testing all the functionality
    // of the Amazon homepage.

    // All the test cases that are related should be in the same class.

    // Classes should contain related functionality, example below.
    // Login, Home, Search, ManageUsers

    // Each class will have related test cases in it, and the names should be self explanatory. Example:
    // test_IsNot_ASenior_If_Age_LessThan_65()
    // test_Fail_To_Withdraw_Money_If_Account_Is_Invalid()
    // test_Student_Is_Not_Admitted_If_Mandatory_Fields_Are_Missing()

    // It's good practice to add comments to your test case so people can easily see what is happening.
    // Val says don't do it for every single test case, we don't need super detailed documentation unless it's
    // really complex.

    // Pre-Conditions
    // They're important, and are what needs to be met before the Test Case can run. Example:
    // 1. Check login
    // 2. Check logged in user has access to manage users

    // We can use reusable methods to verify pre-conditions. Like we can have a method that's only purpose is to
    // log into the site.



    // ANNOTATIONS
    // @Test -> Is the actual test method where we place our code to test the applications.

    // @BeforeMethod -> Method executes before executing each @Test method.  (Executes for each and every @Test)


    // @AfterMethod  -> Executed after each @Test method completes it's execution. (Every single one)

    // @BeforeClass -> Runs only once before the first @Test method in the current class.

    // @AfterClass   -> Runs only one time after all the @Test methods in current class have finished running.




}
