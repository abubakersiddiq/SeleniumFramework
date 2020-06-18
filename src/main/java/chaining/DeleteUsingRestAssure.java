package chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteUsingRestAssure extends BaseClass{
	
	/*/
	 * Using RestAssured, get all the chanege requests
    a) type -> emergency
    b) print onlyy sys_id and type
	 */
	
	@Test(dependsOnMethods= {"chaining.PostChangeRequestRestAssure.postChangeRequest"})
	public void changeRequest() {
			
		
		Response response=
				RestAssured
				.given()
					.log()
					.all()
				.delete(sys_Id);
		
		response.prettyPrint();
		
		int statusCode=response.getStatusCode();
		
		System.out.println("The status code is "+statusCode);
		
	}
	

}
