package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Methods;

public class ContextMenuPage extends Methods{
	
	public ContextMenuPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "hot-spot")
	WebElement dashedFrame;
	
	public void clickContextDashedFrame() {
		clickElementContext(dashedFrame);
	}
	
	public void acceptContextAlert() {
		clickContextDashedFrame();
		waitForAlert();
		acceptAlert();
	}

}
