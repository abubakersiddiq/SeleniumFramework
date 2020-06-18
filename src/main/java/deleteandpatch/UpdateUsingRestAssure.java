package deleteandpatch;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateUsingRestAssure {
	
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
					.log()
					.all()
					.contentType(ContentType.JSON)
				    .body("{\"short_description\": \"Patch using restassuer to update\"}")
				 .patch("95a9edbe2f51101005df811df699b6a7");
		
		response.prettyPrint();
		
		int statusCode=response.getStatusCode();
		
		System.out.println("The status code is "+statusCode);
		
	}
	

}
