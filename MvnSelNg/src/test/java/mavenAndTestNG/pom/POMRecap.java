package mavenAndTestNG.pom;

public class POMRecap {

    // You won't get questions like what's the difference between isDisplayed() and isEnabled()
    // Interview questions will be more about patterns and processes that you use while working with Selenium.


    // PAGE OBJECT MODEL
    // POM is a design pattern that includes Object Repositories for web-elements.

    // Following a design for web pages helps us with refactoring and redesigning code, it makes the maintenance easy.
    // This is so it's easy to tell what class(page) you're working with at a glance.

    // Web Pages are represented as Java classes.
    //      - LoginPage, HomePage, AboutUsPage, SearchResultsPage, etc.

    // All the web-elements of each page are located and stored on the corresponding Page Object class.
    //      - loginButton, userNameInputBox, passwordInputBox, etc.

    // All reusable methods of that web-page are stored in libraries.
    //      - login(String username, String password);
    //
    // Advantages:
    //      - Test cases are seperated from UI web elements and actions.
    //      - Reusability of code.
    //      - Easy maintencance.

    // Whatever page we are dealing with will have its own POM represented in our Java code. (HomePage, LoginPage, etc.)

    // It helps maintainability a lot. If we keep all of our web elements of that web page stored in one place,
    // we can just go back and change the values for that one element if the locator changes, we don't
    // have to go through all of our code checking for each instance of that element.


    // Page Object Class uses Page Factory.
    // Page Factory is a built in POM concept for selenium WebDriver.
    // It provides the @FindBy annotation which we use for locating elements. Example of using it in a constructor below.

                //    public LoginPage(WebDriver driver){
                //        PageFactory.initElements(driver, this);
                //    }




}
