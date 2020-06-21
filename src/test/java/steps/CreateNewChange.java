package steps;

import java.io.File;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateNewChange extends CucumberBase {
	
	@Given("base uri for jira")
	public void base_uri_for_jira() {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI="https://api-mar2020.atlassian.net/rest/api/2/issue/";
	    
	}

	@And("send userAuth")
	public void send_userAuth() {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.authentication = RestAssured.basic("rajalakshmi.govindarajan@testleaf.com", "kEJxzmhkQzvdeP8iysWN2D1B");
	}

	@When("create a new issue in jira using (.*)$")
	public void get_all_the_request_issue_type_from_jira(String fileName) {
	    // Write code here that turns the phrase above into concrete actions
		
		response = RestAssured
				   .given()
				   .contentType(ContentType.JSON)
				   .body(new File("./"+fileName))
				   .post()
				   .then()
				   .log()
				   .all()
				   .extract().response();
	    
	}

	@Then("verify the status code is {int}")
	public void verify_the_status_code_is(int code) {
	    // Write code here that turns the phrase above into concrete actions
	    response.then().assertThat().statusCode(code);
	}

}
