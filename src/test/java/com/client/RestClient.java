package com.client;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class RestClient {
	
	public Response sendGetRequest(String url)
	{
		return given().when().log().all().get(url);
	}
	
	public Response sendPostRequest(String uri, Object requestPayload)
	{
		return given().contentType(ContentType.JSON).when().body(requestPayload).post(uri);
	}
	
	public Response sendPutRequest(String uri, Object requestPayload)
	{
		return given().contentType(ContentType.JSON).when().body(requestPayload).put(uri);
	}
	
	public Response sentPatchReqyest(String uri, Object requestPayload)
	{
		return given().contentType(ContentType.JSON).when().body(requestPayload).patch(uri); 
	}

	public Response sendDeleteRequest(String uri)
	{
		return given().when().delete(uri);
	}
	
}
