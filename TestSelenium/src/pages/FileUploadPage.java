package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Methods;

public class FileUploadPage extends Methods{
	
	public FileUploadPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = ".example h3")
	WebElement confirmTitle;
	
	@FindBy(id = "file-upload")
	WebElement fileField;

	@FindBy(id = "file-submit")
	WebElement fileSubmitButton;
	
	public void clickfileSubmitButton() {
		clickElement(fileSubmitButton);
	}
	
	public void sendFileFieldPath(String text) {
		setElementText(fileField, getFilePath(text));
	}
	
	public String getFileConfirmHeader() {
		return getElementText(confirmTitle);
	}
	
	public void uploadFile(String text) {
		sendFileFieldPath(text);
		clickfileSubmitButton();
	}

}
