package mavenAndTestNG.hrm.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    public LoginPage(WebDriver driver){
        // PageFactory.initElements will allow us to stop using findElement, we will lean more later.
        // It also replaces the this. = x   (it looks like.)
        PageFactory.initElements(driver, this);
    }


    // Notice how many times we are reusing findElement(s). That's not good, we're going to replace them.
    // This allows all of our WebElements to be initalized on object creation.
    // We won't be locally creating WebElements.

    // Pay attention how all the below elements belong to the LoginPage. We can't just add elements from anywhere.
    // We need new classes for new elements.
    @FindBy(id = "txtUsername")
  public  WebElement usernameField;

    @FindBy(id = "txtPassword")
    public WebElement passwordField;

    @FindBy(id = "btnLogin")
    public  WebElement loginBtn;

    @FindBy(id = "spanMessage")
    public WebElement errorMessage;


    // In this method I commented out all of our redundant lines, and it works because of our
    // Constructor with initElements, it requires a driver (coming from the constructor param)
    // and then the this keyword points it to this page. That will populate our WebElements.
    // It will populate this page once we call the constructor.
    public void login(String username, String password){
//        WebElement usernameField = driver.findElement(By.id("txtUsername"));
//        WebElement passwordField = driver.findElement(By.id("txtPassword"));
//        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
    }

    public void verifyUserMessage(String expectedErrorMessage){
//        WebElement errorMessage = driver.findElement(By.id("spanMessage"));
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error message validation has failed");
    }

}
