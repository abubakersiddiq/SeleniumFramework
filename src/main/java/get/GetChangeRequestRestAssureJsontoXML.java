package get;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetChangeRequestRestAssureJsontoXML {
	
	/*/
	 * Using RestAssured, get all the chanege requests
    a) type -> emergency
    b) print onlyy sys_id and type
	 */
	
	/*/
	 * a) get all emergency type CR and 
    b) get the response in XML format 
    c) print the count of it 
    d) print the first sys_id from the response
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
		
		//time and content Type
		 System.out.println(response.contentType());
		 System.out.println(response.time());
		
		//get json from the console
		
		JsonPath jsonValue=response.jsonPath();
		 List<String>ls=jsonValue.getList("result.type");
		 System.out.println(ls.size());
		 for (String lsValue : ls) {
			 
			 System.out.println("get only for emergency from json : " +lsValue);
			
		}
		 
		 
		 //convert to xml
		 
		 Response responseXml=
					RestAssured
					.given()
					.params(paramters)
					.accept(ContentType.XML)
					.get();
		 responseXml.prettyPrint();
		 
		 
		 
		 XmlPath  xmlValue=responseXml.xmlPath();
		 List<String>getXmlList=xmlValue.getList("response.result.sys_id");
		 System.out.println(getXmlList.size());
		 for (String xmlValue1 : getXmlList) {
			 
			 System.out.println("get only for emergency from xml :  " +xmlValue1);
			
			
		}
	}
	

}
