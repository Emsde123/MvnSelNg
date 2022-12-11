package mavenAndTestNG.practice;

import org.testng.annotations.*;

public class AnnotationsPractice {


    // TestNG runs test cases in alphabetical order. We added 1, 2, 3 to the end to make sure they're executed
    // in the right order. We can also use priority, we haven't learned it yet but it's coming.


    @BeforeClass
    public void beforeClass(){
        System.out.println("Hello from @BeforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Hello from @AfterClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Hello from @BeforeMethod");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("Hello from @AfterMethod");
    }

    @Test
    public void testNo1(){
        System.out.println("Hello from Test No. 1");
        // This will call the reusable method, but since there isn't an @Test annotation,
        // it won't call the @BeforeMethod/@AfterMethod methods.
        reusableMethod();
    }

    @Test
    public void testNo2(){
        System.out.println("Hello from Test No. 2");
    }

    @Test
    public void testNo3(){
        System.out.println("Hello from Test No. 3");
    }

    public void reusableMethod(){
        System.out.println("Hello from reusable method");
    }



}
