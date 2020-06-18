package post;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PostChangeRequestRestAssuregetLogintheConsole {
	
	
	@DataProvider(name="getJsonFiles")
	
	public String[] getJsonFiles() {
		
	String[] jsonFile=new String [2];
	
	jsonFile[0]="change.json";
	jsonFile[1]="change2.json";
	
	return jsonFile;
		
	}
	
	
	
	@Test(dataProvider="getJsonFiles")
	public void postChangeRequest(String jsonFileName) {
		
		
		
		RestAssured.baseURI="https://dev63720.service-now.com/api/now/v2/table/change_request";
		
		RestAssured.authentication=RestAssured.basic("admin", "Admin@123");
		
		//Maps 
		
		
		  HashMap<String, String>paramters=new HashMap<String, String>();
		  
		  paramters.put("type", "emergency");
		  paramters.put("sysparm_fields", "sys_id,type");
		
		ValidatableResponse response=
				RestAssured
				.given()
					.log()
					.all()
					.contentType(ContentType.JSON)
					.body(new File(jsonFileName))
				.post()
					.then()
					.log()
					.all();
	}
	

}
