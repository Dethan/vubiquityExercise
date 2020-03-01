package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Methods;

public class IframePage extends Methods{
	
	public IframePage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//iframe[@id='mce_0_ifr']")
	WebElement iframe;
	
	@FindBy(xpath = "//body[@id='tinymce']/p")
	WebElement iframeWriteableSection;
	
	public void sendTextToIframe(String text) {
		switchToLoadedIframe(iframe);
		setElementText(iframeWriteableSection, text);
	}

}
