package otherfeaturesinrestAssure;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;

public class SessionIdUsingGetRequest {
	
	/*/
	 * Using RestAssured, get all the chanege requests
    a) type -> emergency
    b) print onlyy sys_id and type
	 */
	
	@Test
	public void changeRequest() {
		
		RestAssured.baseURI="https://dev63720.service-now.com/api/now/v2/table/change_request";
		//Maps 
		
		  HashMap<String, String>paramters=new HashMap<String, String>();
		  
		 // paramters.put("type", "emergency");
		  paramters.put("sysparm_fields", "sys_id,type");
		  
		  //get the session filter
		  SessionFilter filter=new SessionFilter();

		  Response response=
				RestAssured
					.given()
						.auth()
						.basic("admin", "Admin@123")
						//storing the session id
						.filter(filter)
					.when()
						.params(paramters)
					.and()
						.get();

		System.out.println(" First get method " + filter.getSessionId());
		response.prettyPrint();
		
		int statusCode=response.getStatusCode();
		
		System.out.println("The status code is "+statusCode);
		
		//using same get only passing filter()
		 Response response2=RestAssured
		.given()
		     //getting the same session id with out login it.
			.filter(filter)
		.when()
			.param("type", "emergency")
		.and()
			.get();
		System.out.println("Second get method " +filter.getSessionId());
		response2.prettyPrint();
	}
}
