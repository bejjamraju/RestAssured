package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.*;
import org.testng.annotations.Test;

public class PathAndQueryParameters {
	
	
	@Test
	void testQueryandPathParameters() {
	given()
	//Pre-requisities
	.pathParam("mypath","users") //path parameters
	.queryParam("page","2")  //query param1
	.queryParam("id","2")
	
	.when()
	//type of request
	.get("https://reqres.in/api/{mypath}")
	
	.then()
	// validations.
	.statusCode(200)
	.log().all();
	
	
}
	
	
}
