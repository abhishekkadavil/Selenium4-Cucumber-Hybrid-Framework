
## Test Execution

Execution is start from `runners.TestRunner.java` class. Test that need to execute are defined in the features files present in the Features folder, The set of test cases are identified by appropriate tag name using the tags section in TestRunner class.

## Test Execution Configurations

* **Rerun failed cases:** Add `rerun:target/failedrerun.txt` in the plgin section.
* **Execution mode(paralelly or sequantially):** In scenarios method in `runners.TestRunner.java` class, we can set if the test need to execute paralelly or sequantially. Set the parallel flag to true or false.
* **Report configuration:** Test report high level(suit level) configured will be done through `@BeforeClass` and `@AfterClass` annotations of TestNG inside TestRunner class. Each scenario wise step will be added to report throgh `stepDef.Hooks`.

**RunnerHelper** class will be shared among `runners.TestRunner` and `runners.FailedTCRunner` class to impliment code reusability.

## Test case creation
Test cases are defined in the Features folder in the form of `.feature` file. The first step in the feature file is used to provide the test data used in the test case. Once we get the appropriate test data we can continue rest of the test step.

**Test steps(com.stepDef)**
* This package contain all the step defined in the feature file like
	* Reading test data
	* Do the funtionality like login, create order etc

## Read Test Data
Test data reading start from test data path provided in step defined in the feature file. Test data is provided in JSON file in `TestData/{feature name}/{test case01}` path. We are using `JsonDataReader` class to read the data. This read data is set to the `testDataModels.TestDataModel` using the `TestDataFactory`. Since we want to support the paralell execution hence we are using fatory method and threadlocal class to create TestDataModel per test case using TestDataFactory. In this way each scenario will have its own TestData and will be executed in separate thread.

## Test reporting:

**Suit level configuration:** 
Test report high level(suit level) configured will be done through `@BeforeClass` and `@AfterClass` annotations of TestNG inside TestRunner class. each scenario wise step will be added to report throgh stepDef.Hooks

**Scenario level configuration:**
Each common scenario operations like opening and closing chrome browser, starting and closing test scenario, Adding srceenshots for passsed test etc are done through Cucumber hooks present in the com.stepDef.Hooks class. We are using `@Before` and `@After` hooks of cucumber to achive this. 

**Step level configuration:**
For test step status management are using listener class named `com.utils.TestListener` which impliments cucumber plugin `ConcurrentEventListener`. Using this plugin we are managing the status of the test cases by monitoring test steps. We are handling three main status **FAILED, PASSED, SKIPPED**.

## Scenario context
`com.utils.TestContext` is used to share the state between test steps. i.e During the execution if we want to store the order number in one step and use that order number in different step, then we need to use TestContext. TestContext contain a map we can use this map to manipulate data.

**Configuration:**
Configurations for the test suits are done through `com.utils.ConfigUtil` interface which extends `org.aeonbits.owner.Config`. 
Suit level configuration are done in `@BeforeClass` of TestRunner.

## Other utils:
**WaitHelper:** This helper class contains all the type of waits for the framework. like JS wait, explicit wait etc...


## Feature need to add 
* Remove the models after the use from memmory
* Logs are not present
* stepDef need to link with pageObject package
* Scenario context need to be optimised
