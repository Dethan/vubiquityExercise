package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Methods;

public class DynamicControlsPage extends Methods{
	
	public DynamicControlsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement removeButton;
	
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	WebElement addButton;
	
	@FindBy(xpath = "//input[@id='checkbox']")
	WebElement checkbox;
	
	@FindBy(xpath = "//form[@id='input-example']//input[@type='text']")
	WebElement disableSelect;
	
	@FindBy(xpath = "//button[contains(text(),'Enable')]")
	WebElement enableButton;
	
	public void clickRemoveButton() {
		clickElement(removeButton);
	}
	
	public void clickAddButton(){
		clickElement(addButton);
	}
	
	public void clickCheckBox() {
		clickElement(checkbox);
	}
	
	public void clickEnableButton() {
		clickElement(enableButton);
	}
	
	public Boolean checkIfEnabledSelect() {
		return checkIfWebelementIsDisabled(disableSelect);
	}
	
	public void writeInDisabledSelect(String text) {
		if	(!checkIfEnabledSelect()) {
			clickEnableButton();
		}
		webElementClickable(disableSelect);
		clickElement(disableSelect);
		setElementText(disableSelect, text);
	}
}
