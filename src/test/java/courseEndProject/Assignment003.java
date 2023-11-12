package courseEndProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Assignment003 {
	Logger logger = LogManager.getLogger(Assignment003.class);
	
	@Test
	public void assignment003User()
	{
		logger.info("Course End project - Assignment003 - GET user request");
		RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2/user/Uname001")
		.when()
		.get()
		.then()
		.statusCode(200)
		.log().all()
		.body("username", Matchers.equalTo("Uname001"))
		.body("email", Matchers.equalTo("Positive@Attitude.com"))
		.body("userStatus", Matchers.equalTo(1));
		
		
	}
	
}
