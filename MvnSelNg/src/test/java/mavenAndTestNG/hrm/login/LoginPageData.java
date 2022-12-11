package mavenAndTestNG.hrm.login;

import org.testng.annotations.DataProvider;

public class LoginPageData {
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
