package okta;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateClient {

	String authKey="0088cFP_MhbWEPqczXD73wFJgoZXUZIu2GHSEKYSgL";
	Response resp;

	@BeforeSuite
	public void setUpBaseURI() {
		RestAssured.baseURI="https://dev-375976-admin.okta.com/oauth2/v1/clients";

	}


	@Test
	public void createOKtaclient() {
		
		File fsJson=new File("./oktacreate.json");
		
		//headers 
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("Authorization", "SSWS"+authKey);





		resp = RestAssured
			.given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.headers(parameters)
			.body(fsJson)
				.post()
				.then()
				.log()
				.all()
				.extract()
				.response();

	}
	@AfterSuite
	public void clientGetStatusCode() {
		
		int statusCodeIs=resp.getStatusCode();
		
		System.out.println(statusCodeIs);
		resp.then().assertThat().statusCode(201);

	}


}
