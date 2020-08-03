package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;

public class GetlssueTypeFromJira extends CucumberBase {
	
	@Given("base uri for jira")
	public void base_uri_for_jira() {
	    // Write code here that turns the phrase above into concrete actions
		//"https://api-mar2020.atlassian.net/rest/api/2/issuetype"
		RestAssured.baseURI="https://"+serverName+resource+"/";	
	    
	}

	@And("send userAuth")
	public void send_userAuth() {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.authentication = RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com", "kEJxzmhkQzvdeP8iysWN2D1B");
	}

	@And("get all the request issue type from jira")
	public void get_all_the_request_issue_type_from_jira() {
	    // Write code here that turns the phrase above into concrete actions
		
		response = RestAssured.get("issuetype")
					.then()
						.log()
						.all()
						.extract()
						.response();	    
	}

	@Then("verify the status code is {int}")
	public void verify_the_status_code_is(int code) {
	    // Write code here that turns the phrase above into concrete actions
		status_code=response.getStatusCode();
		System.out.println(" status is : " +status_code);
	    response.then().assertThat().statusCode(code);
	}

}
