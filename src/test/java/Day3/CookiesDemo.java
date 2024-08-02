package Day3;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.json.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
//	@Test(priority = 1)
	void testCookies() {
		
		given()

		.when()
		
		.get("https://google.com/")
		
		.then()
		
		.statusCode(200)
//		.cookie("AEC","AVYB7crSAtwploEfFZ7Pt8cYSc9Iff5Qv2BocRhgw6JDEA-Blj6-60M0Jvk;")
		.log().all();
		
	}
	
	
	@Test(priority = 2)
	void getCookiesInfo() {
		
	 Response res =	given()
		.when()
		.get("https://www.google.com/");	
	 
	   // SIngle cookie
//	 	String cookievalue = res.getCookie("AEC");
//	 	System.out.println("Value of Cookie is------->"+cookievalue);
			 
	 //get all cookies info
	 Map<String, String> cookie_values = res.getCookies();
	 
//	 System.out.println(cookie_values.keySet());
	 for(String k: cookie_values.keySet()) {
		 System.out.println(k+"           "+res.getCookie(k));
	 }
		
	}

}
