package utils;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class RequestMethods {
	
	protected OkHttpClient httpClient;
	
	public RequestMethods(OkHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public RequestBody generateJsonRequestBody(String values) {
		String json = getJsonRequest(values);
		MediaType mediaType = MediaType.parse("application/json");
    	RequestBody body = RequestBody.create(mediaType, json);
    	return body;
	}
	
	public String getJsonRequest(String filename) {
		return filename;
	}
	
	public Request generatePostRequest(String json, String requestURL, String token) {
		RequestBody body = generateJsonRequestBody(json);
		Request request = new Request.Builder()
              .url(requestURL)
              .method("POST", body)
              .addHeader("Content-Type", "application/json")
              .addHeader("Authorization", token)
              .build();
		return request;
	}
	
	public Request generateGetRequest(String requestURL, String token) {
		Request request = new Request.Builder()
              .url(requestURL)
              .method("GET", null)
              .addHeader("Content-Type", "application/json")
              .addHeader("Authorization", token)
              .build();
		return request;
	}
	
	public String getFilePath(String text) {
		Path path = FileSystems.getDefault().getPath(text).toAbsolutePath();
		return path.toString();
	}
	
}
