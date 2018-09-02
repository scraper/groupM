package apiTest;

import org.testng.Assert;
import org.testng.annotations.*;
import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class ApiTest {

	@BeforeClass
	public void setBaseUri () {
	
		RestAssured.baseURI = "https://www.metaweather.com/";
	}

	@Test
	public void testStatusCode () {
	    
		Response res = 
	    given ()
	    .param ("query", "Berlin")
	    .when()
	    .get ("api/location/search/");
		
//		res.body().prettyPrint();
		System.out.println("Actual status code: " + res.statusCode());
	    Assert.assertEquals (res.statusCode (), 200);
	}
	
	@Test
	public void testContentType () {
	    
		Response res = 
	    given ()
	    .param ("query", "Berlin")
	    .when()
	    .get ("api/location/search/");
		
//		res.body().prettyPrint();
		System.out.println("Actual content type: " + res.contentType());
	    Assert.assertEquals (res.contentType(), "application/json");
	}
	
	@Test
	public void testParams () {
	    
		Response res = 
	    given ()
	    .param ("query", "")
	    .when()
	    .get ("api/location/search/");
		
//		res.body().prettyPrint();
		System.out.println("Actual content type: " + res.statusCode());
	    Assert.assertEquals (res.statusCode(), 403);
	}
}