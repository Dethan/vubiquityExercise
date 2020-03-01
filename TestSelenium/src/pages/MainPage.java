package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Methods;

public class MainPage extends Methods{
	
	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//a[contains(text(),'Basic Auth')]")
	WebElement basicAuthLink;
	
	@FindBy(xpath ="//a[contains(text(),'Checkboxes')]")
	WebElement checkboxesLink;
	
	@FindBy(xpath ="//a[contains(text(),'Context Menu')]")
	WebElement contextMenuLink;
	
	@FindBy(xpath ="//a[contains(text(),'Dropdown')]")
	WebElement dropdownLink;
	
	@FindBy(xpath ="//a[contains(text(),'Dynamic Controls')]")
	WebElement dynamicControlsLink;
	
	@FindBy(xpath ="//a[contains(text(),'File Upload')]")
	WebElement fileUploadLink;
	
	@FindBy(xpath ="//a[contains(text(),'Frames')]")
	WebElement framesLink;
	
	@FindBy(xpath ="//a[contains(text(),'JQuery UI Menus')]")
	WebElement jqueryMenusLink;
	
	@FindBy(xpath ="//a[contains(text(),'Multiple Windows')]")
	WebElement multipleWindowsLink;
	
	@FindBy(xpath ="//a[contains(text(),'Sortable Data Tables')]")
	WebElement sortableTablesLink;
	
	
	public void clickBasicAuthLink() {
		clickElement(basicAuthLink);
	}
	
	public void clickCheckBoxesLink() {
		clickElement(checkboxesLink);
	}
	
	public void clickContextMenuLink() {
		clickElement(contextMenuLink);
	}
	
	public void clickDropdownLink() {
		clickElement(dropdownLink);
	}
	
	public void clickDynamicControlsLink() {
		clickElement(dynamicControlsLink);
	}
	
	public void clickFileUploadLink() {
		clickElement(fileUploadLink);
	}
	
	public void clickFramesLink() {
		clickElement(framesLink);
	}
	
	public void clickJqueryMenusLink() {
		clickElement(jqueryMenusLink);
	}
	
	public void clickMultipleWindowsLink() {
		clickElement(multipleWindowsLink);
	}
	
	public void clickSortableTablesLink() {
		clickElement(sortableTablesLink);
	}

}
