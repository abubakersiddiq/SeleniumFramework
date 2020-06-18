package get;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetChangeRequestRestAssure {
	
	/*/
	 * Using RestAssured, get all the chanege requests
    a) type -> emergency
    b) print onlyy sys_id and type
	 */
	
	@Test
	public void changeRequest() {
		
		
		RestAssured.baseURI="https://dev63720.service-now.com/api/now/v2/table/change_request";
		
		RestAssured.authentication=RestAssured.basic("admin", "Admin@123");
		
		//Maps 
		
		
		  HashMap<String, String>paramters=new HashMap<String, String>();
		  
		  paramters.put("type", "emergency");
		  paramters.put("sysparm_fields", "sys_id,type");
		
		Response response=
				RestAssured
				.given()
				.params(paramters)
				.get();
		
		response.prettyPrint();
		
		int statusCode=response.getStatusCode();
		
		System.out.println("The status code is "+statusCode);
		
	}
	

}
