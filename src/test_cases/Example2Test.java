package test_cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Example2Test {

	@Test
	public void test_case_2() {
		
		String URL_endpoint = "https://reqres.in/api/users/";
		String userID = "40";
		Response GET_response;
					
		GET_response =  RestAssured.get(URL_endpoint+userID);
		System.out.println(GET_response.statusLine());
		System.out.println(GET_response.asPrettyString());
			
		// xác minh status code 200
		assertEquals(GET_response.statusCode(), 404);
				
		// Xác minh kết quả trả về có trường message hay không
		assertTrue(GET_response.asPrettyString().contains("message"));
			
		// Xác minh nội dung của trường message	
		assertEquals(GET_response.jsonPath().get("message"), "User not found!"); 
		
		
		
		
		
	}
	
	
	
	
	
}
