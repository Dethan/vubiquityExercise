package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import utils.Methods;

public class CheckBoxPage extends Methods{
	
	public CheckBoxPage(WebDriver driver) {
		super(driver);
	}
	
	String checkBoxes = "//input[@type='checkbox']"; 
	
	public void checkCheckboxes() {
		List<WebElement> list = getElementsList(checkBoxes);
		
		for(WebElement element: list) {
			if(!element.isSelected()) {
				element.click();
			}
		}
	}

}
