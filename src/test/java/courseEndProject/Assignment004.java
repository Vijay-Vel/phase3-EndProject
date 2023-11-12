package courseEndProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Assignment004 {

	Logger logger = LogManager.getLogger(Assignment004.class);
	@Test
	public void assignment004login()
	{
		
		logger.info("Course End project - Assignment004 - GET login request");
		RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2/user/login")
		.auth().preemptive().basic("Uname001", "@tt!tude")
		.when()
		.get()
		.then()
		.statusCode(200)
		.log().all()
		.body("message", Matchers.anything())
		.body("type", Matchers.equalTo("unknown"))
		.body("code", Matchers.equalTo(200))
		;
	
		
		
	}
}
