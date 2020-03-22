package App.Script;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;

import App.Generic.Endpoint;
import App.Generic.ResponseCode;
import App.Generic.URL;
import App.Generic.WebServicesMethod;

public class GetUser_TestCases {

	Response response;
	static ResponseCode re = new ResponseCode();
	String UserVal = "1";

	@Test
	public void GetUser() {
		String GetUserUrl = URL.Endpoint + Endpoint.GETSINGLEUSER.getresourcePath(new GetUser_TestCases().UserVal);
		System.out.println(GetUserUrl);
		response = WebServicesMethod.GetRequest(GetUserUrl);
		int ActualR = response.getStatusCode();
		int ExpectedValue = re.SuccessResponseCode;
		AssertJUnit.assertEquals(ActualR, ExpectedValue);

	}

	@Test
	public void GetUserNegative() {
		String GetUserUrl = URL.Endpoint + Endpoint.GETSINGLEUSER.getresourcePath(new GetUser_TestCases().UserVal);
		response = WebServicesMethod.GetRequest(GetUserUrl);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		int ActualR = response.getStatusCode();
		int ExpectedValue = re.ServerResponseCode;
		AssertJUnit.assertEquals(ActualR, ExpectedValue);
	}

	@Test
	public void GetUserNegative_InvalidURI() {
		String GetUserUrl = URL.Endpoint + Endpoint.GETSINGLEUSER.getresourcePath(new GetUser_TestCases().UserVal)
				+ "//855";
		response = WebServicesMethod.GetRequest(GetUserUrl);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		int ActualR = response.getStatusCode();
		System.out.println(ActualR);
		int ExpectedValue = re.PageNotFoundResponseCode;
		AssertJUnit.assertEquals(ActualR, ExpectedValue);
	}

}
