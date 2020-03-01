package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Methods;

public class TodayPage extends Methods{
	
	public TodayPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css=".heading")
	WebElement siteHeader;
	
	public String getSiteHeader() {
		return getElementText(siteHeader);
	}
	
	public String getCurrentPageTitle() { 
		return getPageUrl();
	}
	
	public void returnToPreviousPage() {
		returnPage();
	}
	

}
