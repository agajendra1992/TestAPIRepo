package App.Generic;

import org.apache.http.entity.ContentType;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class WebServicesMethod {

	static Response response;

	public static Response GetRequest(String URI) {
		RequestSpecification requestspec = RestAssured.given();
		requestspec.content(ContentType.APPLICATION_JSON);
		response = requestspec.get(URI);
		return response;
	}

	public static Response PostRequest(String URI, String jsonbody) {
		RequestSpecification requestspec = RestAssured.given().body(jsonbody);
		requestspec.content(ContentType.APPLICATION_JSON);
		response = requestspec.post(URI);
		return response;
	}

	public static Response PutRequest(String URI, String jsonbody) {
		RequestSpecification requestspec = RestAssured.given().body(jsonbody);
		requestspec.content(ContentType.APPLICATION_JSON);
		response = requestspec.put(URI);
		return response;

	}
	public static Response DeleteRequest(String URI) {
		RequestSpecification requestspec = RestAssured.given();
		requestspec.content(ContentType.APPLICATION_JSON);
		response = requestspec.delete(URI);
		return response;

	}
}
