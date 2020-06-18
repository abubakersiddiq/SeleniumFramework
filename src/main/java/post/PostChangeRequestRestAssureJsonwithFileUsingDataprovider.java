package post;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostChangeRequestRestAssureJsonwithFileUsingDataprovider {
	
	
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
		
		Response response=
				RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(new File(jsonFileName))
				.post();
		
		response.prettyPrint();
		
		int statusCode=response.getStatusCode();
		
		System.out.println("The status code is "+statusCode);
		
	}
	

}
