package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Methods;

public class DropdownPage extends Methods{
	
	public DropdownPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "dropdown")
	WebElement dropdown;
	
	public void selectDropdownOption(String option) {
		selectDropdownOptionByText(dropdown, option);
	}

}
