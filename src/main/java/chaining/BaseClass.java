package chaining;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;

public class BaseClass {
	
	static String sys_Id;
	
	@BeforeMethod
	public void requestIntial() {
		
	RestAssured.baseURI="https://dev63720.service-now.com/api/now/v2/table/change_request";	
	RestAssured.authentication=RestAssured.basic("admin", "Admin@123");
		
	}

}
