package mavenAndTestNG.homework.demoguru99HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;


public class HW {

    WebDriver driver;


    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/newtours/");
        Thread.sleep(1500);
    }





    @Test
    public void verify_no_flights_available_NY_Paris() throws InterruptedException {

        Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");

        driver.findElement(By.xpath("//a[text()='Flights']")).click();
        Thread.sleep(1500);

        WebElement passengerDropDownElement = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passDropDown = new Select(passengerDropDownElement);
        passDropDown.selectByVisibleText("2");

        WebElement departingDropDownElement = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingDropDown = new Select(departingDropDownElement);
        departingDropDown.selectByVisibleText("New York");

        WebElement fromMonthDropDownElement = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select fromMonthDropDown = new Select(fromMonthDropDownElement);
        fromMonthDropDown.selectByVisibleText("June");

        WebElement fromDayDropDownElement = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select fromDayDropDown = new Select(fromDayDropDownElement);
        fromDayDropDown.selectByVisibleText("1");


        WebElement arrivingDropDownElement = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivingDropDown = new Select(arrivingDropDownElement);
        arrivingDropDown.selectByVisibleText("Paris");

        WebElement toMonthDropDownElement = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select toMonthDropDown = new Select(toMonthDropDownElement);
        toMonthDropDown.selectByVisibleText("November");

        WebElement toDayDropDownElement = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select toDayDropDown = new Select(toDayDropDownElement);
        toDayDropDown.selectByVisibleText("6");

        WebElement businessClass = driver.findElement(By.xpath("//input[@value='Business']"));
        businessClass.click();

        WebElement airlineDropDownElement = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineDropDown = new Select(airlineDropDownElement);
        airlineDropDown.selectByVisibleText("Unified Airlines");

        WebElement continueBtn = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueBtn.click();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        String noFlightsMessage = "flight finder - No Seats Avaialble";
        boolean flightAvailable = false;

        if(!bodyText.contains(noFlightsMessage)){
            flightAvailable = true;
        }

        Assert.assertEquals(flightAvailable, false, "No flights available assertion has failed.");


    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
