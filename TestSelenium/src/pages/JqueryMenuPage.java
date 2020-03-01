package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Methods;

public class JqueryMenuPage extends Methods{

	public JqueryMenuPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//a[contains(text(),'Enabled')]")
	WebElement enabledMenuLink;
	
	@FindBy(xpath ="//a[contains(text(),'Downloads')]")
	WebElement downloadsMenuLink;
	
	@FindBy(xpath ="//a[contains(text(),'Excel')]")
	WebElement excelMenuLink;
	
	@FindBy(xpath ="//a[contains(text(),'Back to JQuery UI')]")
	WebElement backToJqueryMenuLink;
	
	@FindBy(xpath ="//a[contains(text(),'Menu')]")
	WebElement jQueryMenuLink;
	
	
	public void clickExcelOption() {
		//hoverOnWebElement(enabledMenuLink);
		clickElement(enabledMenuLink);
		//hoverOnWebElement(downloadsMenuLink);
		clickElement(downloadsMenuLink);
		clickElement(excelMenuLink);
	}
	
	public void clickBackToJqueryOption() {
		clickElement(enabledMenuLink);
		clickElement(backToJqueryMenuLink);
	}
	
	public Boolean checkIfMenuLinkExist() {
		return webElementExist(jQueryMenuLink);
	}
}
