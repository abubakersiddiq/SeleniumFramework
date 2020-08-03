package runner;

import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@CucumberOptions(features="src/test/java/features/Jira.feature",
                 glue= {"steps"},
                 monochrome=true)
public class Run extends AbstractTestNGCucumberTests {

	@DataProvider
	public Object[][] getData() {
		
		return super.scenarios();
		
	}
}
