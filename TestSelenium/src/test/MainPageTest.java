package test;

import org.testng.annotations.Test;
import org.testng.Assert;

import utils.BaseTest;

public class MainPageTest extends BaseTest{
	
	String welcomePageMessage = "Welcome to the-internet";
	
	@Test
	public void basicAuthTest() {
		Assert.assertEquals(todayPage().getSiteHeader(),welcomePageMessage);
		mainPage().clickBasicAuthLink();
		basicAuthPage().loginAlert("admin", "admin");
		Assert.assertEquals(todayPage().getPageUrl(),baseUrl+"/basic_auth");
	}
	
	@Test
	public void checkboxesTest() {
		Assert.assertEquals(todayPage().getSiteHeader(),welcomePageMessage);
		mainPage().clickCheckBoxesLink();
		Assert.assertEquals(todayPage().getPageUrl(),baseUrl+"/checkboxes");
		checkBoxPage().checkCheckboxes();
	}
	
	@Test
	public void contextMenuTest() {
		Assert.assertEquals(todayPage().getSiteHeader(),welcomePageMessage);
		mainPage().clickContextMenuLink();
		Assert.assertEquals(todayPage().getPageUrl(),baseUrl+"/context_menu");
		contextMenuPage().clickContextDashedFrame();
		contextMenuPage().acceptContextAlert();
		todayPage().returnPage();
	}
	
	@Test
	public void dropdownTest() {
		Assert.assertEquals(todayPage().getSiteHeader(),welcomePageMessage);
		mainPage().clickDropdownLink();
		Assert.assertEquals(todayPage().getPageUrl(),baseUrl+"/dropdown");
		dropdownPage().selectDropdownOption("Option 1");
		dropdownPage().selectDropdownOption("Option 2");
		todayPage().returnPage();
	}
	
	@Test
	public void dynamicControlsTest() {
		Assert.assertEquals(todayPage().getSiteHeader(),welcomePageMessage);
		mainPage().clickDynamicControlsLink();
		Assert.assertEquals(todayPage().getPageUrl(),baseUrl+"/dynamic_controls");
		dynamicControlsPage().clickRemoveButton();
		dynamicControlsPage().clickAddButton();
		dynamicControlsPage().clickCheckBox();
		Assert.assertFalse(dynamicControlsPage().checkIfEnabledSelect());
		dynamicControlsPage().writeInDisabledSelect("Hello World!");
	}
	
	@Test
	public void fileUploadTest() {
		Assert.assertEquals(todayPage().getSiteHeader(),welcomePageMessage);
		mainPage().clickFileUploadLink();
		Assert.assertEquals(todayPage().getPageUrl(),baseUrl+"/upload");
		fileUploadPage().uploadFile("testng.xml");
		Assert.assertEquals(fileUploadPage().getFileConfirmHeader(),"File Uploaded!");
	}
	
	@Test
	public void framesTest() {
		Assert.assertEquals(todayPage().getSiteHeader(),welcomePageMessage);
		mainPage().clickFramesLink();
		Assert.assertEquals(todayPage().getPageUrl(),baseUrl+"/frames");
		framesPage().clickIframelink();
		Assert.assertEquals(todayPage().getPageUrl(),baseUrl+"/iframe");
		iFramePage().sendTextToIframe("This Text is From Automation Script");
	}
	
	@Test
	public void jqueryMenusTest() {
		Assert.assertEquals(todayPage().getSiteHeader(),welcomePageMessage);
		mainPage().clickJqueryMenusLink();
		Assert.assertEquals(todayPage().getPageUrl(),baseUrl+"/jqueryui/menu");
		jqueryMenuPage().clickExcelOption();
		jqueryMenuPage().clickBackToJqueryOption();
		Assert.assertTrue(jqueryMenuPage().checkIfMenuLinkExist());
	}
	
	@Test
	public void multipleWindowsTest() {
		Assert.assertEquals(todayPage().getSiteHeader(),welcomePageMessage);
		mainPage().clickMultipleWindowsLink();
		Assert.assertEquals(todayPage().getPageUrl(),baseUrl+"/windows");
		multipleWindowsPage().clicClickHereLink();
		multipleWindowsPage().switchToOpenedLinkTab();
		Assert.assertEquals(multipleWindowsPage().getNewTabLabel(),"New Window");
		multipleWindowsPage().closeOpenedLinkTab();
		multipleWindowsPage().clicClickHereLink();
	}

	@Test
	public void sortableTablesTest() {
		Assert.assertEquals(todayPage().getSiteHeader(),welcomePageMessage);
		mainPage().clickSortableTablesLink();
		Assert.assertEquals(todayPage().getPageUrl(),baseUrl+"/tables");
		sortableTablesPage().sortTable1ByFirstName();
		System.out.println(sortableTablesPage().getCellTextEmailBySearchText("John"));
		sortableTablesPage().sortTable1ByLastName();
		System.out.println(sortableTablesPage().getCellTextWebPageBySearchText("Conway"));
	}
	

}
