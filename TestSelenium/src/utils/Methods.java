package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.interactions.Actions;

public class Methods {
	WebDriverWait wait;
	WebDriver driver;
	JavascriptExecutor js;
	Actions actions;
	String parentWindow;
	Pattern pattern;
	Matcher matcher;
	
	public Methods(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		this.js = (JavascriptExecutor)driver;
		this.actions = new Actions(driver);
		this.parentWindow = driver.getWindowHandle();
		PageFactory.initElements(driver, this);
	}
	
	public void webElementVisible(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
	}
	
	public void frameVisible(WebElement element) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public void selectVisible(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeSelected(element));
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
		
	}
	
	public void webElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForAlert() {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
		} 
		catch(ElementNotVisibleException e) {
			e.printStackTrace();
		}
		
	}
	
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();	
		} catch (UnhandledAlertException e) {
		e.printStackTrace();
		}
		
	}
	
	public void setElementText(WebElement element, String text) {
		webElementVisible(element);
		element.clear();
		element.sendKeys(text);
	}
	
	public void setIframetText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void clickElement(WebElement element) {
		webElementVisible(element);
		element.click();
	}
	
	public String getElementText(WebElement element) {
		webElementVisible(element);
		return element.getText();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void loginAlert(String user, String pass) {
		waitForAlert();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(user+Keys.TAB+pass);
		alert.accept();
	}
	
	public List<WebElement> getElementsList(String element) {
		List<WebElement> list = driver.findElements(By.xpath(element));
		return list;
	}
	
	public void returnPage() {
		js.executeScript("window.history.go(-1)", 5000);
	}
	
	public void clickElementJS(WebElement element) {
		webElementVisible(element);
		js.executeScript("arguments[0].click();", element);
	}
	
	public void clickElementContext(WebElement element) {
		webElementVisible(element);
		actions.moveToElement(element);
		actions.contextClick();
		actions.perform();
	}
	
	public void hoverOnWebElement(WebElement element) {
		webElementVisible(element);
		actions.moveToElement(element).perform();
	}
	
	public void selectDropdownOptionByText(WebElement element, String text) {
		webElementVisible(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public Boolean checkIfWebelementIsDisabled(WebElement element) {
		webElementVisible(element);
		return element.isEnabled();
	}
	
	public void switchToLoadedIframe(WebElement element) {
		frameVisible(element);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(element);
	}
	
	public Boolean webElementExist(WebElement element) {
		webElementVisible(element);
		return element.isDisplayed();
	}
	
	public void switchToOpenedTab() {
		for(String childWindow:driver.getWindowHandles())
		if(!childWindow.equals(parentWindow))
		    driver.switchTo().window(childWindow);
	}
	
	public void closeCurrentTab() {
		driver.close();
		for(String window:driver.getWindowHandles())
			if(!window.equals(parentWindow))
			    driver.switchTo().window(window);
	}
	
	public String getEmailFromText(String text) {
		String mails="";
		pattern = Pattern.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");
		matcher = pattern.matcher(text);
		while(matcher.find())
			mails += matcher.group();
		return mails;
	}
	
	public String getFilePath(String text) {
		Path path = FileSystems.getDefault().getPath(text).toAbsolutePath();
		return path.toString();
	}
	
	
	public String getEmailBySearchTextInRows(List<WebElement> rows, String text) {
		String email = "No Email Found";
		for(WebElement row: rows) {
			if(row.getText().contains(text)) {
				email = getEmailFromText(row.getText());
			}
		}
		return email;
	}
	
	public String getWebPageFromText(String text) {
		String mails="";
		pattern = Pattern.compile("((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		matcher = pattern.matcher(text);
		while(matcher.find())
			mails += text.substring(matcher.start(1),matcher.end());
		return mails;
	}
	
	
	public String getWebPageBySearchTextInRows(List<WebElement> rows, String text) {
		String email = "No Email Found";
		for(WebElement row: rows) {
			if(row.getText().contains(text)) {
				email = getWebPageFromText(row.getText());
			}
		}
		return email;
	}

}
