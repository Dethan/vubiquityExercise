package utils;

import org.testng.annotations.BeforeMethod;
import okhttp3.OkHttpClient;
import requests.UsersRequests;

public class BaseRequest {
	
	protected OkHttpClient httpClient; 
	
	public UsersRequests usersRequests() {
		UsersRequests usersRequests = new UsersRequests(httpClient);
		return  usersRequests;
	}
	    
	@BeforeMethod
	public void beforeMethod() {
		httpClient = new OkHttpClient().newBuilder().build();		
	}

}
