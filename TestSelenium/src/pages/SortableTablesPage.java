package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Methods;

public class SortableTablesPage extends Methods{
	
	public SortableTablesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//table[@id='table1']//span[contains(text(),'First Name')]")
	WebElement table1FirstNameHeader;
	
	@FindBy(xpath = "//table[@id='table1']//span[contains(text(),'Last Name')]")
	WebElement table1LastNameHeader;
	
	@FindBy(xpath = "//table[@id='table1']//tr")
	List<WebElement> tableRows;
	
	public void sortTable1ByFirstName() {
		clickElement(table1FirstNameHeader);
	}
	
	public void sortTable1ByLastName() {
		clickElement(table1LastNameHeader);
	}
	
	public String getCellTextEmailBySearchText(String text) {
		return getEmailBySearchTextInRows(tableRows, text);
	}
	
	public String getCellTextWebPageBySearchText(String text) {
		return getWebPageBySearchTextInRows(tableRows, text);
	}
	
}
