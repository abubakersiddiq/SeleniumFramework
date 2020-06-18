package get;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetChangeRequestRestAssureUsingParam {
	
	/*/
	 * Using RestAssured, get all the chanege requests
    a) type -> emergency
    b) print onlyy sys_id and type
	 */
	
	@Test
	public void changeRequest() {
		
		
		RestAssured.baseURI="https://dev63720.service-now.com/api/now/v2/table/change_request";
		
		RestAssured.authentication=RestAssured.basic("admin", "Admin@123");
		
		Response response=
				RestAssured
				.given()
				.param("type", "emergency")
				.param("sysparm_fields", "sys_id,type")
				.get();
		
		response.prettyPrint();
		
		int statusCode=response.getStatusCode();
		
		System.out.println("The status code is "+statusCode);
		
	}
	

}
