package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.restassured.RestAssured;



@CucumberOptions(features="src/test/java/features/CreateChangeRequest.feature",glue= {"steps"})
public class Run extends AbstractTestNGCucumberTests {

	

}
