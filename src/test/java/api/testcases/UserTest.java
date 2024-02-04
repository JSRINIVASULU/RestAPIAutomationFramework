package api.testcases;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payload.user;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	user userPayload;
	public static Logger logger;
	
	@BeforeClass
	public void generateTestData() {
		faker = new Faker();
		userPayload = new user();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//obtain logger
		logger = LogManager.getLogger("RestAssuredAutomationFramework");
		
		
	}
	
	@Test(priority=1)
	public void testCreateUser() {
		Response response = userEndPoints.createUser(userPayload);
		
		System.out.println("*************Read user data**************");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(),200);
		
		//log
				logger.info("Create User Executed...");
		
	}
	
	@Test(priority=2)
	public void testGetUser() {
		Response response = userEndPoints.getUser(this.userPayload.getUsername());
		
		System.out.println("*************Get user data**************");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(),200);
		
		//log
		logger.info("Get User Data Executed...");
	}
	
	@Test(priority=3)
	public void testUpdateUser() {
		userPayload.setFirstName(faker.name().firstName());
		Response response = userEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		
		System.out.println("*************Update user data**************");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(),200);
		
		//Read user date to check if firstname is updated
		Response responsePostUpdate = userEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		System.out.println("*************Post Update user data**************");
		responsePostUpdate.then().log().all();
		
		//log
		logger.info("Update User Executed...");
	}
	
	@Test(priority=4)
	public void testDeleteUser() {
		Response response = userEndPoints.deleteUser(this.userPayload.getUsername());
		
		System.out.println("*************Delete user data**************");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(),200);
		
		//log
		logger.info("Delete User Executed...");
	}
	
}
