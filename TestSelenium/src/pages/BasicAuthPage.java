package pages;

import org.openqa.selenium.WebDriver;

import utils.Methods;

public class BasicAuthPage extends Methods{
	
	public BasicAuthPage(WebDriver driver) {
		super(driver);
	}
	
	public void loginBasicAuthAlert(String user, String pass) {
		loginAlert(user, pass);
	}
}
