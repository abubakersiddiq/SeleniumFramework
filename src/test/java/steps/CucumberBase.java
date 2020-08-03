package steps;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CucumberBase {
	
	public RequestSpecification request; 
	public Response response;
	
	public String serverName="api-mar2020.atlassian.net";
	public String resource="/rest/api/2";
	
	String getIssueId;
	int status_code;

}
