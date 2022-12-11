package Cucumber;

public class FrameworkBasics {

    // Testing Frameworks
    // Think of the different types of frameworks as being under one umbrella of "Types of Test Automation Frameworks"
    //   Under that umbrella we have things like:
    //  - Modular Testing Framework
    //  - Data Driven Testing Framework
    //  - Keyword Driven Testing Framework
    //  - Hybrid Testing Framework
    //  - Behavior Driven Development Framework
    //  These are different from the pre-defined frameworks like Junit, TestNG, Cucumber, etc.


    // Every framework will have their own types of verification points.
    // What was the type of verification we were dealing with for the past few weeks with Maven?
    // We've been working with a hybrid testing framework.
    // Because we've been dealing with data (creating/deleting users)
    // We've used behavior driven development (user should be able to x, user should be able to see y, then x)
    // We used modular testing when we separated each page into their own classes with their own test cases.

    // TestNG is a framework, but we treat it more like a tool. Same with Junit and Cucumber.
    // They're technically frameworks but we use them like tools. This is where user-defined frameworks come in.
    // We can incorporate multiple tool frameworks into the user defined frameworks we'll be using to test our application.



    // ATDD - Acceptance Test Driven Development
    // 1. In BDD, PO and BA will first write the acceptance criteria scenarios that describe the behavior
    //    of the system from the customers' perspective. (Raw requirements, no details)
    // 2. It is reviewed and approved by the POs before devs start writing their codes.
    // 3. Acceptance Test is written, which fails in the beginning, because the actual program isn't buit yet.
    // 4. Devs write code to implement the User Story
    // 5. Automation Tester writes their automation code in parallel.
    // 6. Once the user story is done, tests will be run and pass.

    // It's a cycle like SDLC is.
    // 1. Describe Behavior
    // 2. Write step definition
    // 3. Run and fail
    // 4. Write code to make step pass
    // 5. Run and pass


    // Interview Question:
    //      What do testers do while the application is in the development stage?
    //          - I will go and start on creating my page classes based on the mock version of the application.
    //            design the framework based off what the website will look like, and leave out the locators.
    //            Basically I will create my blueprint of what my framework will look like, but without locators.
    //            I will be missing locators, test data, and my configuration data. But it will save time to design it
    //            as a blueprint.


    // Cucumber Introduction
    // In BDD acceptance criteria and test cases are written in a way that simulates user behavior.
    //           Given the user x
    //           When the user does x
    //           Then x
    // Cucumber is used to write AND test user stories.
    // In Cucumber, user stories are written using Gherkin language.
    // It's just like plain english, it is readable by Non-Technical people, like BA, PO, etc.

    // Advantages of Cucumber
    //  Helps involve Business stakeholders who can't easily read code.
    //  Cucumber testing focuses on end-user experience
    //  Style of writing tests allow for easier reuse of code in the tests.
    //  Efficient tool for testing.

    // In BDD there is basically 3 layers, with one extra on top. (3 musketeers + Runner Class)
    //      - Runner class
    //          Handles execution (Replaces our XML file.)
    //          We will only build the runner class once, and tweak it as needed.
    //      - Feature file
    //          Contains our steps (given, when, then)
    //      - Step Definitions
    //          This is where we will start writing our code.
    //          We will have the feature file that has the steps, and in this
    //          step we will be defining all the steps in our feature file.
    //          basically giving the steps their own behavior.
    //      - Page Objects
    //          The step definitions will be connected to our page object classes.
    //          Each page object class will call methods from our step definitions.


    //                                  Feature File
    //  Feature File -> Can contain one feature, and one or more scenarios for the features.
    //          - Feature: login
    //  Scenario     -> Contains multiple steps to execute that scenario
    //          - Scenario: Login with correct credentials
    //          - Scenario: Login with incorrect credentials
    //          - Scenario: Forgot password
    //  Steps        -> Each line in scenario is considered to be a step.
    //          - Steps are formed using gherkin keywords: Given, When, Then, And, But








}
