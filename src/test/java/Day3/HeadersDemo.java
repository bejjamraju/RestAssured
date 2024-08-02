package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.json.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {
//	@Test(priority = 1)
	void testHeaders() {	
		
		given()
		
		.when()
		  .get("https://google.com/")	
		
		.then()
			.header("Content-Type","text/html; charset=ISO-8859-1")
			.and()
			.header("Server","gws")
			.log().headers();
	}
	@Test(priority = 2)
	void getHeaders() {	
		
		Response resp = given()
				.when()
					.get("https://google.com/");	
		String headervalue = resp.getHeader("Content-Type");
		System.out.println("The value of Content-Type header is : "+headervalue);
		
		//get all headers info
		
		Headers myheaders = resp.getHeaders();
		for(Header hd:myheaders) {
			System.out.println(hd.getName()+"           "+hd.getValue());			
			
		}
		
		
	}
	
}
