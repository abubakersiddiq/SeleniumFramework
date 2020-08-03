package okta;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetClientAndID {

	String authKey="0088cFP_MhbWEPqczXD73wFJgoZXUZIu2GHSEKYSgL";
	Response resp;
	String clientId;

	@BeforeSuite
	public void setUpBaseURI() {
		RestAssured.baseURI="https://dev-375976-admin.okta.com/oauth2/v1/clients";

	}


	@Test
	public void getOKtaClientID() {


		resp = RestAssured
				.given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.headers("Authorization", "SSWS"+authKey)
				.get()
				.then()
				.log()
				.all()
				.extract()
				.response();

		JsonPath jsonValue=resp.jsonPath();
	    clientId=jsonValue.get("[0].client_id");
		System.out.println(" Clent id is :  " +clientId);

	}
	@AfterSuite
	public void clientGetStatusCode() {

		int statusCodeIs=resp.getStatusCode();

		System.out.println(statusCodeIs);
		
		resp.then().assertThat().statusCode(200);

	}


}
