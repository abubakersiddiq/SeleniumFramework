package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.restassured.RestAssured;



@CucumberOptions(features="src/test/java/features/Jira.feature",glue= {"steps"})
public class Run extends AbstractTestNGCucumberTests {

	

}
