## Overview
A boilerplate framework that helps you to write automation tests for E2E using selenium.
#### Note:
Implemented healenium(self-healing selenium) in branch origin/healenium.
Execute `sudo docker-compose up` in `Selenium4-Cucumber-Hybrid-Framework/infra` directory.
<span style="color:red"> **Since it does not provide extensive support, and having a low community resulting the feature to does not merge into the master branch.** </span>

healenium setup: https://github.com/healenium/healenium-example-maven

## Features
* Cucumber test case
* Parallel/sequential execution
* Healenium https://github.com/abhishekkadavil/Selenium4-Cucumber-Hybrid-Framework/pull/12 - AI powered self-healing selenium
* Selenium grid support
* Execute through maven, testng.xml, java class[TestRunner.java]
* Rerun only failed cases
* Auto/customisable reporting
* Scenario context
* Added `@Author` and `@Category` tags in reporting so that we can categorise with different parameters. eg: [Login.feature](Features/Login.feature)
* Logs support
* Configurable environment
* Interaction helper and wait utils functions
* Controllable browser version - `chromeVersion` in [Config.properties](src/main/resources/Config.properties)
* Controllable browser with respect to scenario eg: Login_Scenario5
* Retry flaky test cases(Not implemented in TestNG.xml execution, same can be implemented using annotation transformer of TestNG) - `MaxFlakyTestRetryCount` and `FlakyTestRetryFlag` in [Config.properties](src/main/resources/Config.properties)
* We can control if the test need to continue execution, if the certain number of test is failed. eg: `@PassTestNoExecutionControl`
  * If we have total of 10 tests, and we need to skip the test after failing first 5 test, We can use this by defining PassTestExecutionControlNumFlag and PassTestExecutionControlNum in config property file
* Selenium-Grid execution videos recordings can be reviewed later [Go to Permissions](#Permissions)
* We can dockerise the framework if needed by referring [Dockerfile](Dockerfile)

## Prerequisite

#### Test application
https://github.com/abhishekkadavil/nopCommerce#how-to-run

#### Plugins needed
* Cucumber for Java
* Gherkin
* Lombok
* Maven
* TestNG
* SonarQube(Former SonarLint)

#### Permissions
* Selenium-Grid video recordings - If your using Ubuntu, The recordings might be with limited permission, hence cannot be played. We can play the recordings by executing below commands
	* Create folder if it's not already exist
		* mkdir -p ./TestRecordings
	* Give permission to [TestRecordings](TestRecordings)
		* sudo chown -R $USER:$USER ./TestRecordings
		* sudo chmod -R 777 ./TestRecordings
	* ive permission to files inside [TestRecordings](TestRecordings)
		* sudo chown -R $USER:$USER ./*

## Test Execution

### We can execute the test in different ways
* Locally
	* Through maven
		* `mvn clean test` to execute test from `testng.xml` through maven.
		* To execute specific tags from command line we can use mvn test -> `-Dcucumber.filter.tags="@All"`
		* Can pass browser type and execution type from maven cli -> mvn test `-Dcucumber.filter.tags="@All" -Dbrowser=firefox -DexecType=local`
		* Default value for browser and execType is chrome and local
		* If test need to execute I grid env then pass the execType as grid eg: `-Dcucumber.filter.tags="@All" -Dbrowser=firefox -DexecType=grid`
	* Through `testng.xml`
	* Through the `TestRunner.java` class
* Using selenium grid
	* selenium docker grid(**docker-compose.yml**) can be up using `docker-compose up`
    * Update `EnvironmentName` to `grid` in [Config.properties](src/main/resources/Config.properties)
	* check if grid is up: `http://localhost:4444/ui/`
	* currently there is three Chrome browser node, ie three virtual machine with Chrome browser
	* During the grid execution we can see what's happening on each node, For that we can use second port mentioned in the `docker-compose.yml` node section eg: `http://localhost:7901/` for chrome(**Password: secret**)
* Rerun failed cases: Add `rerun:target/failedrerun.txt` in the plugin section.

In any point the execution in framework is start from `runners.TestRunner.java` class. Test that need to execute are defined in the features files present in the Features folder, The set of test cases are identified by appropriate tag name using the tags section in TestRunner class.

## Test Execution Configurations

* **Execution mode(parallel or sequentially):** In scenarios method in `runners.TestRunner.java` class, we can set if the test need to execute parallel or sequentially. Set the parallel flag to true or false.
	* The default test case count executing at a time is specified in the `testng.xml`, The default value is `2`
* **Report configuration:** Test report high level(suit level) configured will be done through `@BeforeClass` and `@AfterClass` annotations of TestNG inside TestRunner class. Each scenario wise step will be added to report through `stepDef.Hooks`.

**RunnerHelper** class will be shared among `runners.TestRunner` and `runners.FailedTCRunner` class to implement code re-usability.

## Test case creation
Test cases are defined in the Features folder in the form of `.feature` file. The first step in the feature file is used to provide the test data used in the test case. Once we get the appropriate test data we can continue rest of the test step. The testdata fields in the json file should same as the fields present in the model class.

**Test steps(com.stepDef)**
* This package contain all the step defined in the feature file like
	* Reading test data
	* Do the functionality like login, create order etc

## Read Test Data
Test data reading start from test data path provided in step defined in the feature file. Test data is provided in JSON file in `TestData/{feature name}/{test case01}` path. We are using `JsonDataReader` class to read the data. This read data is set to the `testDataModels.TestDataModel` using the `TestDataFactory`. Since we want to support the parallel execution hence we are using factory method and thread-local class to create TestDataModel per test case using TestDataFactory. In this way each scenario will have its own TestData and will be executed in separate thread. Instead of thread local concept we can also use `@ScenarioScoped` but here we are not using it, Not any particular reason to ignore it, but I want the framework to include all the knowledge I learn from open source community.

We only need to provide necessary fields that need the test to execute eg: `TestData/Login/Scenario01.json` vs `TestData/FirstTimeOrder/Scenario01.json`

## Test reporting:

**Suit level configuration:**
Test report high level(suit level) configured will be done through `@BeforeClass` and `@AfterClass` annotations of TestNG inside TestRunner class. each scenario wise step will be added to report through `stepDef.Hooks`

**Scenario level configuration:**
Each common scenario operations like opening and closing Chrome browser, starting and closing test scenario, Adding screenshots for passed test etc. are done through Cucumber hooks present in the com.stepDef.Hooks class. We are using `@Before` and `@After` hooks of cucumber to achieve this.

**Step level configuration:**
For test step status management are using listener class named `com.listeners.TestListener` which implements cucumber plugin `ConcurrentEventListener`. Using this plugin we are managing the status of the test cases by monitoring test steps. We are handling three main status **FAILED, PASSED, SKIPPED**.

## Scenario context
All the operations which are common in scenario level like **driver management, data passing between test step** are 
done through `com.utils.ScenarioContext`. i.e. During the execution if we want to share the driver or store the order number in one step and use that order number in different step, then we need to use ScenarioContext.
* ScenarioContext is marked with `@ScenarioScoped`, so the class will have separate copy of instance for each scenario
* ScenarioContext contain a map we can use this map to manipulate data.
* We are using google-guice for DI

## Configuration:
Configurations for the test suits are done through `com.utils.ConfigUtil` interface which extends `org.aeonbits.owner.Config`. Suit level configuration are done in `ScenarioContext` class.

## Logs:
We are using `slf4j` to implement `log4j` through `lombok`

## Other utils:
**WaitHelper:** This helper class contains all the type of waits for the framework. like JS wait, explicit wait etc...

## Test output
* The output of the test execution like order number, payment id etc. can be logged in report for the later use, so 
  didn't create any other mechanism for that.

## Other Features
* Added Same test case with multiple types of data - Scenario outline mode
* Added TestNG file so that we can control the thread count in parallel mode
* In the current framework, we have optimised the page management by combining POM with step def files. By doing so, it is easily manageable, also creating new test cases requires only a small effort.
* Added `google-juice` and `cucumber-juice` for managing the state of driver object, class object, etc
* Added the `@ScenarioScoped`(the object of a class marked this annotation is only created for one scenario and destroyed after the use)
	* Added functionality of ScenarioContext to accommodate all the common functions in a scenario perspective, eg, initialising and quitting a browser driver
	* Made the BrowserFactory to `@ScenarioScoped` since we want to support parallel testing, each scenario needed a new instance of the  driver
* Added `InteractionHelper` class so less code in step def classes
* Most of the exceptions are also handled in the `InteractionHelper` class
* Added `preserve-order="true"` in `testng.xml` to maintain order in the execution
* Modal class implemented with Lombok
* Added `ActionHelper` class
* Added `WaitHelper` class
* Suppressed Chrome driver and Selenium warning message
* Added a gitignore file to ignore unnecessary file tracking
* Controllable browser with respect to the scenario - 
* Retry flaky test cases

## Why and Why Not
* OOPS, used in framework
	* `Runnerhelper` class
* Why cucumber-TestNG? Why not Cucumber, TestNG, JUnit, etc?
  * I implemented Cucumber-TestNG so that we can use both TestNG and Cucumber features 
    * Used IRetryAnalyzer for retrying flaky tests
    * Used annotations like @BeforeClass, @AfterClass, @DataProvider, @Test etc
  * Increase the test readability
  * Easy to maintain
  * Easy to update or add tests (rather than using code to create/update a test case, we can reuse the steps to create/update test cases)
* Design Principle
  * KISS
* Design pattern used
	* Added factory design pattern in the framework - selecting the browser mechanism
	* DI injection in Test context
    * Singleton pattern
* No need to put the locators in the exec or properties file because it's not efficient. If we implement such an ecosystem, we have to create and maintain separate files and related classes to maintain that ecosystem, which is an overkill
* Why not use the grass hopper extend report plugin - it doesn't support cucumber 7, it's not as flexible as I wanted
* Why use Google Guice instead of Pico Container or Spring
	* google guice - can do DI(object creation) with annotations and have `@ScenarioScoped` annotation which will make the state management easy
	* pico container - Do not have `@ScenarioScoped` annotation
	* spring - this is complex
* Why not Cucumber+JUnit - Cucumber+JUnit will not allow us to execute scenarios in parallel, only feature files in parallel, but TestNG can.
* Why not use the thread-local concept to manage the driver? - Found Google juice, so went with that method because it's easy to implement. we can manage state using DI(`@Inject`) and `@ScenarioScoped` annotations
* For logging, SLF4j is used because it serves as a simple facade or abstraction for various logging frameworks (e.g. 
  java.util.logging, logback, log4j), allowing the end user to plug in the desired logging framework at deployment time. If log4j has any vulnerability issue, we can use logback or java.util.logging. Since this is an interface, we can easily unplug and plug the frameworks
* Only used explicit wait, adding implicit and explicit wait in the same framework, the selenium works in unexpected way - mentioned in the documentation, so removed it.
* Did not use page factory here is why - https://www.youtube.com/watch?v=e1esWQ_nZPE&list=PL9ok7C7Yn9A_JZFMrhrgEwfqQGiuyvSkB&index=13
* Since [InteractionHelper.java](src/main/java/com/stepdef/InteractionHelper.java) does not share any state(no static or class variable present in the class, so state will not be shared, local variables will not share state), that is why we didn't make the class static. In the future, if there are any class-level variables that needed to be declared, then the suit will have unexpected behaviors. Also, I don't like to make the functions tightly coupled, hence not done that.

## Feature needs to be added
* Dockerized the framework
	* https://codefresh.io/blog/not-ignore-dockerignore-2/
* DB Connection should be in a singleton pattern
* Need to run test case from feature file instead of test runner file
* Integrate with slack - https://www.youtube.com/watch?v=BsLFhe_1By8&list=PLNky9jSTCKG3j0WwqMDFOrr3XMlaSsKOY&index=12
* Need to add souce labs 
* Need to add browser stack 
* Need to integrate with aws 
* Need to create artifactory for the framework
