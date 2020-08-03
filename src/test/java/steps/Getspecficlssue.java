package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;

public class Getspecficlssue extends CucumberBase {
	
	
@And("get specific issue with issueNo")
	public void getSpecificIssue() {
	    // Write code here that turns the phrase above into concrete actions
		
		response = RestAssured.get("issuetype/"+getIssueId)
					.then()
					.log()
					.all()
					.extract()
					.response();	    
	}

@Then("verify the status code is {int}")
	public void verify_the_status_code_is(int code) {
	    // Write code here that turns the phrase above into concrete actions
	    response.then().assertThat().statusCode(code);
	}

}
