package mavenAndTestNG.assertions;

public class AssertionsLesson1Recap {

    // TestNG framework is all about comparing expected vs actual result.
    // It shows passed, failed, and skipped test cases.
    // If exceptions happen in TestNG, only that method fails.

    // TestNG can do some of these important things:
    // Order of execution -> @Test(priority=1)
    // Parallel execution -> By using XML file you can do cross browser testing in parallel
    // Parameterized Tests -> By using @Data Providers
    // Using TestNG you can get an HTML report by default
    // Dependency Test -> Allows a test method to depend on a single or a group of Test methods.
    //                    - Uncaught exceptions are automatically handled without terminating the test prematurely
    //                       These exceptions are reported as failed steps in the report.



    // Assertions

    // assertTrue(boolean condition, "reason why failed");
    // This method verifies weathjer fiven parameter results in true.
    //    -assertTrue(3<4)

    // assertFalse(boolean condition, "reason why failed");
    // - This method verifies weather given parameter results in false.

    // assertEquals(actual, expected);
    //   - Checks weather 2 primitives/objects are equal.
    //   - Assert.assertEquals(actual, expected, "reason why failed")

    // assertNotEquals(actual, expected);
    //   - Verifies the given 2 objects and fails if both are the same.
    //   - Assert.assertNotEquals(actual, expected, "reason why")

    // assertNotSame(actual, expected)   <-- Pretty much only used by devs

    // assertNull();
    // assertNotNull();   <-- are both also basically never used by us, we can use these with API testing though.







}
