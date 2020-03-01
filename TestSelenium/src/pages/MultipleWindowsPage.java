package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Methods;

public class MultipleWindowsPage extends Methods{

	public MultipleWindowsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//a[contains(text(),'Click Here')]")
	WebElement clickHereLink;
	
	@FindBy(css = ".example h3")
	WebElement newWindowLabel;
	
	public void clicClickHereLink() {
		clickElement(clickHereLink);
	}
	
	public void switchToOpenedLinkTab() {
		switchToOpenedTab();
	}
	
	public String getNewTabLabel() {
		return getElementText(newWindowLabel);
	}
	
	public void closeOpenedLinkTab() {
		closeCurrentTab();
	}
	
}
