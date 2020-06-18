package post;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostChangeRequestRestAssureJsonFile {
	
	
	
	@Test
	public void postChangeRequest() {
		
		//To read file 
		
		File jsonFiles=new File("./change.json");
		
		
		RestAssured.baseURI="https://dev63720.service-now.com/api/now/v2/table/change_request";
		
		RestAssured.authentication=RestAssured.basic("admin", "Admin@123");
		
		//Maps 
		
		
		  HashMap<String, String>paramters=new HashMap<String, String>();
		  
		  paramters.put("type", "emergency");
		  paramters.put("sysparm_fields", "sys_id,type");
		
		Response response=
				RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(jsonFiles)
				.post();
		
		response.prettyPrint();
		
		int statusCode=response.getStatusCode();
		
		System.out.println("The status code is "+statusCode);
		
	}
	

}
