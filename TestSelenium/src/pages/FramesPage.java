package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Methods;

public class FramesPage extends Methods{

	public FramesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//a[contains(text(),'iFrame')]")
	WebElement iframeLink;
	
	public void clickIframelink() {
		clickElement(iframeLink);
	}
	
	
}
