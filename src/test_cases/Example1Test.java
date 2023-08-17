package test_cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Example1Test{
	
	@Test
	public void test_case_1() {
		
		String URL_endpoint = "https://reqres.in/api/users/";
		String userID = "2";
		Response GET_response;
					
		GET_response =  RestAssured.get(URL_endpoint+userID);
		System.out.println(GET_response.statusLine());
		System.out.println(GET_response.asPrettyString());
			
		// xác minh status code 200
		assertEquals(GET_response.statusCode(), 200);
				
		// Xác minh kết quả trả về có trường id hay không
		assertTrue(GET_response.asPrettyString().contains("id"));
		
		// Xác minh kết quả trả về có trường email hay không
		assertTrue(GET_response.asPrettyString().contains("email"));
		
		// Xác minh kết quả trả về có trường first_name hay không
		assertTrue(GET_response.asPrettyString().contains("first_name"));
		
		// Xác minh kết quả trả về có trường last_name hay không
		assertTrue(GET_response.asPrettyString().contains("last_name"));
		
		// Xác minh kết quả trả về có trường avatar hay không
		assertTrue(GET_response.asPrettyString().contains("avatar"));
		
		// Xác minh kết quả trả về của user ID
		assertEquals(GET_response.jsonPath().get("data.id").toString(), userID);
		
		
		
		
	}
	
	
	
	
}
