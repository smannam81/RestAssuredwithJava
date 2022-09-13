package com.tests;

//import com.client.RestClient;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.RestClient;

//import com.client.RestClient;

public class Sampletest {
	
	@Test
	void Sample1(){
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://gorest.co.in";
		String url = "/public/v2/users";
		RestClient rest = new RestClient();
		
		//Response res = given().when().log().all().get(url);
		
		Response res = rest.sendGetRequest(url);
		
		given().when().contentType(ContentType.JSON).log().all().get(url).then().assertThat().statusCode(200);
		System.out.println(res.asPrettyString());
		System.out.println(res.statusCode());
		Assert.assertEquals(res.statusCode(), 200); 
		System.out.println("Testcase is successfully executed");
		long time = given().when().get(url).timeIn(TimeUnit.MILLISECONDS);
		System.out.println(time);
				
	}

}
