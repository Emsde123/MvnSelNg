package mavenAndTestNG.homework.hrmHW;

import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

public class HW2Data {

    @DataProvider(name = "credentials")
    public Object [][] getCredentialsAndErrorMessage(){
        return new Object[][]{
                {"yoll-student12345", "Bootcamp5###", "Invalid credentials"},
                {"", "Bootcamp5#####", "Username cannot be empty"},
                {"yoll-student", "", "Password cannot be empty"},
                {"", "", "Username cannot be empty"}
        };
    }





}
