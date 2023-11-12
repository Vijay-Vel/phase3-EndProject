package courseEndProject;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Assignment002 {
	
Logger logger = LogManager.getLogger(Assignment002.class);
	
	@Test(priority='1')
	public void assignment002Post()
	{
		logger.info("Course End project - Assignment002 - POST request");
		File file = new File("resources/data.json");
		int id = RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2/pet")
		.contentType(ContentType.JSON)
		.body(file)
		.when().post()
		.then()
		.statusCode(200)
		.log().all()
		.body("name", Matchers.equalTo("duck")).extract().path("id");
	logger.trace("The status code is checked");
	
	System.out.println(id);
	
	logger.trace("Id has been captured and validated");
		
	}
	
	
	@Test(priority='2',dependsOnMethods = "assignment002Post")
	public void assignment002Put()
	{
		File file = new File("resources/dataput1.json");
	int id = RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2/pet/")
		.contentType(ContentType.JSON)
		.body(file)
		.when()
		.post()
		.then()
		.statusCode(200)
		.log().all()
		.body("status", Matchers.equalTo("available_QA")).extract().path("id");
	
	System.out.println(id);
	}

}
