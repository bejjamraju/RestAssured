package Day1;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


/*

given()

content-type/ cookies/auth/headers

when()

Get Request/Post/put/delete

then()

assertions/validations/extract response body/headers/cookies

*/

public class HTTPRequests {
	
	
	int id;
	
	@Test(priority = 1)
	void getUsers() {
	when()
		.get("https://reqres.in/api/users?page=2")
	.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
		
	}
	@Test(priority = 2)
	void createUsers() {
		
		HashMap data = new HashMap();
		data.put("name", "morpheus");
		data.put("job", "leader");
		id=given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
//		.then()
//			.statusCode(201)
//			.log().all();
	}
	@Test(priority = 3,dependsOnMethods = {"createUsers"})
	void updateUsers() {
		HashMap data = new HashMap();
		data.put("name", "morpheus");
		data.put("job", "senior");
		given()
				.contentType("application/json")
				.body(data)
			.when()
				.put("https://reqres.in/api/users/"+id)
			.then()
			  .statusCode(200)
			  .log().all();
		
	}
	@Test(priority = 4)
	void deleteUsers() {
				
		when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();
	}
	
	
	
	
	
	
}
