package seva;
import org.testng.Assert;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Test
public class ValidateResponse {
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://www.boredapi.com";
		RestAssured.basePath = "/api/activity";
	}
	
	public void statuscodeVerification() {
		String abc = null;

		Response response = 
		given().param("type", "recreational")
		.headers("Content-Type", "application/json; charset=utf-8")
		.when()
		.get()
		.then()
		.extract().response();
		String text = response.asString();
		System.out.print("text"+text);
		
		JsonPath js = new JsonPath(text);
		
		System.out.print("texti"+js);
		
		abc = js.getString("type");
		System.out.print("/n****"+abc);
		
		Assert.assertEquals(abc, "recreational");
		
		
	//	String def = js.getString("value.type");
		//System.out.print("def"+def);
		
	
	}

}
