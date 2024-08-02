package Day2;


import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;


/* Diff ways 
 * HashMap
 * Using org.json
 * using pojo class
 * using external json file
 */

class DiffWaystoCreatePostRequests {
	
	int id;
	
//	@Test(priority = 1)
	public void testPostUsingHashMap() {
		HashMap data = new HashMap();
		
	data.put("name", "Pablo Escobar");
	data.put("location", "USA");
	data.put("phone", "87487");
	String coursesArr[]={"Auto QA","QA Performance"};
	data.put("courses", coursesArr);
	
	
	
	given()
	.contentType("application/json")
	.body(data)
	.when()
		.post("http://localhost:3000/students")
	.then()
	.statusCode(201)
//	.body("name", equalTo("John"))
//	.body("location", equalTo("India"))
//	.body("phone", equalTo("914917497194"))
//	.body("courses[0]", equalTo("Automation"))
//	.body("courses[1]", equalTo("Performance"))
	.header("Content-type","application/json")
	.log().all();	
	}
	
	
//using org.json
	
//	@Test
	void testPostusingJsonlibrary() {
		JSONObject data = new JSONObject();
		data.put("name","Chandra");
		data.put("name", "Sekhar");
		data.put("location", "USA");
		data.put("phone", "75879");
		String coursesArr[]={"QA","Dev"};
		data.put("courses", coursesArr);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
		.statusCode(201);
	}
	
//	@Test(priority = 2)
	void delete() {
		when()
		.delete("http://localhost:3000/students/"+id)
		.then()
		.statusCode(200)
		.log().all();
	}
	
//	@Test
	void testPostusingPojo() {
		Pojo_PostRequest pojo = new Pojo_PostRequest();
		pojo.setName("Naga");
		pojo.setLocation("Germany");
		pojo.setPhone("9857577677");
		String coursesArr[] = {"C","C++"};
		pojo.setCourses(coursesArr);
		given()
		.contentType("application/json")
		.body(pojo)
		
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.log().all();
		
	}
	
	 @Test
	 void testPostusingExternalfile() throws FileNotFoundException {
		 File f = new File(".\\body.json");
			FileReader fr = new FileReader(f);
			JSONTokener jt = new JSONTokener(fr);
		 JSONObject data = new JSONObject(jt);
		 
		 given()
		 	.contentType("application/json")
		 	.body(data)
		 .when()
		 	.post("http://localhost:3000/students")
		 .then()
		 	.statusCode(201)
		 	.log().all();
	 }

}