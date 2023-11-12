package courseEndProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Assignment005 {

	Logger logger = LogManager.getLogger(Assignment005.class);

	@Test
	public void assignment005FindByStatus()
	{
		logger.info("Course End project - Assignment005 - GET status request");
		
		RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2/pet/findByStatus")
		//.queryParam("status", "available")
		.queryParam("status", "pending")
		//.queryParam("status", "sold")
		.when()
		.get()
		.then()
		.statusCode(200)
		.log().all();
	
		
		
	}
}
