package jiraassment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetIssueInJira {
	
	/*/
	 *  In Jira, you need to do the following in Rest Assured !!
        a) Get all the issues created in the project (in 24 hours)
        b) Create a new issue using json file 
        c) Create attachment for that newly created issue (snapshot.png)
        d) Delete that issue
        Note: Use pre-emptive auth
	 * 
	 */
	
	String userName="rajalakshmi.govindarajan@testleaf.com";
	String passWord="kEJxzmhkQzvdeP8iysWN2D1B";
	
	//get issue in jira
	@Test
	 public void getAllIssue() {
		 
		 RestAssured.baseURI="https://api-mar2020.atlassian.net/rest/api/2/search";
		 
		 RestAssured.authentication=RestAssured.preemptive().basic(userName,passWord);
		 
		  Response response = RestAssured
				  				.given()
				  					.log()
				  					.all()
				  					.param("jql", "project=MAY")
				  				.get();
		  
		  response.prettyPrint();
		  
		  System.out.println(response.statusCode());
		  
		  JsonPath json = response.jsonPath();
		  
		  List<String> created = json.getList("issues.fields.created");
		 
		  for (int i = 0; i < created.size(); i++) {
			
			  DateFormat format=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		}
		 
		
	}

}
