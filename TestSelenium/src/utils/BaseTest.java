package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.MainPage;
import pages.MultipleWindowsPage;
import pages.SortableTablesPage;
import pages.TodayPage;
import pages.BasicAuthPage;
import pages.CheckBoxPage;
import pages.ContextMenuPage;
import pages.DropdownPage;
import pages.DynamicControlsPage;
import pages.FileUploadPage;
import pages.FramesPage;
import pages.IframePage;
import pages.JqueryMenuPage;

public class BaseTest {
	
	protected WebDriver driver;
	protected String baseUrl;
	
	
	public TodayPage todayPage() {
		TodayPage todayPage = new TodayPage(driver);
		return todayPage;
	}
	
	public MainPage mainPage() {
		MainPage mainPage = new MainPage(driver);
		return mainPage;
	}
	
	public BasicAuthPage basicAuthPage() {
		BasicAuthPage basicAuthPage = new BasicAuthPage(driver);
		return basicAuthPage;
	}
	
	public CheckBoxPage checkBoxPage() {
		CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
		return checkBoxPage;
	}
	
	public ContextMenuPage contextMenuPage() {
		ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
		return contextMenuPage;
	}
	
	public DropdownPage dropdownPage() {
		DropdownPage dropdownPage = new DropdownPage(driver);
		return dropdownPage;
	}
	
	public DynamicControlsPage dynamicControlsPage() {
		DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
		return dynamicControlsPage;
	}
	
	public FileUploadPage fileUploadPage() {
		FileUploadPage fileUploadPage = new FileUploadPage(driver);
		return fileUploadPage;
	}
	
	public FramesPage framesPage() {
		FramesPage framesPage = new FramesPage(driver);
		return framesPage;
	}
	
	public IframePage iFramePage() {
		IframePage iFramePage = new IframePage(driver);
		return iFramePage;
	}
	
	public JqueryMenuPage jqueryMenuPage() {
		JqueryMenuPage jqueryMenuPage = new JqueryMenuPage(driver);
		return jqueryMenuPage;
	}
	
	public MultipleWindowsPage multipleWindowsPage() {
		MultipleWindowsPage multipleWindowsPage = new MultipleWindowsPage(driver);
		return multipleWindowsPage;
	}
	
	public SortableTablesPage sortableTablesPage() {
		SortableTablesPage sortableTablesPage = new SortableTablesPage(driver);
		return sortableTablesPage;
	}
	
	@BeforeMethod
	public void beforeMethod() {
		baseUrl = "http://the-internet.herokuapp.com";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dethan\\Desktop\\Caliz\\TestSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
