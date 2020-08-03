package okta;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteClient extends GetClientAndID {

	String authKey="0088cFP_MhbWEPqczXD73wFJgoZXUZIu2GHSEKYSgL";
	Response resp;

	@BeforeSuite
	public void setUpBaseURI() {
		RestAssured.baseURI="https://dev-375976-admin.okta.com/oauth2/v1/clients";

	}


	@Test
	public void deleteOKtaClientID() {


		resp = RestAssured
				.given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.headers("Authorization", "SSWS"+authKey)
				.delete("/"+clientId)
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

		resp.then().assertThat().statusCode(204);

	}
}
