package Day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class TestLogs {
	@Test
	void testLogs() {
		given()
		
		.when()
			.get("https://google.com/")
		.then()
			.log().cookies();
	}
}
