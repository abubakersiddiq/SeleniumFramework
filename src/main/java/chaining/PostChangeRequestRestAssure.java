package chaining;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostChangeRequestRestAssure extends BaseClass {

	@Test
	public void postChangeRequest() {

		// Maps

		HashMap<String, String> paramters = new HashMap<String, String>();

		paramters.put("type", "emergency");
		paramters.put("sysparm_fields", "sys_id,type");

		Response response = RestAssured
				               .given()
				               .log()
				               .all()
				               .contentType(ContentType.JSON)
				               .body("{\"short_description\": \"Abubaker\"}")
				               .post();
		response.prettyPrint();

		int statusCode = response.getStatusCode();

		System.out.println("The status code is " + statusCode);
		
		  JsonPath jsonRespone = response.jsonPath(); 
		  sys_Id=jsonRespone.get("result.sys_id"); 
		  System.out.println(sys_Id); 
		 
	}
}
