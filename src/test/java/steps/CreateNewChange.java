package steps;

import java.io.File;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateNewChange {

	RequestSpecification request; 
	Response response;

	@Given("the base URI")
	public void baseURI() {
		RestAssured.baseURI="https://dev63720.service-now.com/api/now/v2/table/change_request";

	}

	@And("set basic authentication")
	public void setAuthentation() {

		RestAssured.authentication=RestAssured.basic("admin", "Admin@123");

	}
	@And("add body from (.*)")
	public void setBody(String fileName) {
		
		File file=new File("./"+fileName);

		request = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(file);

	}

	@When("post the request")
	public void placeRequest() {

		response= request.post();

	}
	@Then("status code should be (.*)")
	public void verifyStatus(int code) {

		response.then().assertThat().statusCode(code);

	}

}
