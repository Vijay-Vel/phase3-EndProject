package courseEndProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Assignment006 {
	
	Logger logger = LogManager.getLogger(Assignment006.class);
	@Test
	public void assignment006Logout()
	{
		logger.info("Course End project - Assignment006 - GET logout request");
		
		RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2/user/logout")
		.when()
		.get()
		.then()
		.statusCode(200)
		.log().all()
		.body("code", Matchers.equalTo(200))
		.body("type", Matchers.equalTo("unknown"))
		.body("message", Matchers.equalTo("ok"));
		
		
	}

}
