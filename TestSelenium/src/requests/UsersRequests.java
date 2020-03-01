package requests;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import utils.RequestMethods;

public class UsersRequests extends RequestMethods{
	
	String requestURL = "http://dummy.restapiexample.com/api/v1";
	String token = "Basic VVNcR1UyMUdBOkdvbHU5MDA4MjJoamNtdmwwMi8=";
	
	public UsersRequests(OkHttpClient httpClient) {
		super(httpClient);
	}
	
	public String sendNewUserPost(String filename) throws IOException{
		Request request = generatePostRequest(filename, requestURL+"/create", token);
		Response response = httpClient.newCall(request).execute();
		return "httpCode:"+response.code()+" | "+response.body().string();
	}
	
	public String getNewUserById(String id) throws IOException{
		Request request = generateGetRequest(requestURL+"/employee/"+id, token);
		Response response = httpClient.newCall(request).execute();
		return "httpCode:"+response.code()+" | "+response.body().string();
	}
	

}
