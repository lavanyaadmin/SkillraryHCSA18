package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompPages.ContactUsPage;
import pompPages.CoreJavaForSeleniumPage;
import pompPages.CoreJavaVideoPage;
import pompPages.HomePage;
import pompPages.SeleniumTrainingPage;
import pompPages.SkillraryDemoAppPage;
import pompPages.TestingPage;

public  class BaseClass {
	
	 protected PropertiesUtility property;
	
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected HomePage home;
	protected SkillraryDemoAppPage demoApp;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected CoreJavaForSeleniumPage coreJava;
	protected ContactUsPage contact;
	protected CoreJavaVideoPage javavideo;

	//@BeforeSuite
	//@BeforeTests
	@BeforeClass
	public void classConfiguration() {
		property=new PropertiesUtility();
		excel=new ExcelUtility();
		 web=new WebDriverUtility();
		 property.PropertiesInitialization(Iconstantpath.PROPERTIES_FILE_PATH);
		 excel.excelInitialization(Iconstantpath.EXCEL_FILE_PATH);
	}
	@BeforeMethod
	public void methodConfiguration() {
		long time=Long.parseLong(property.fetchProperty("timeouts"));
		 driver=web.openApplication(property.fetchProperty("browser"),property.fetchProperty("url"));
		home=new HomePage(driver);
		Assert.assertTrue(home.getLogo().isDisplayed());
		demoApp=new SkillraryDemoAppPage(driver);
		selenium=new SeleniumTrainingPage(driver);
		testing=new TestingPage(driver);
		coreJava=new CoreJavaForSeleniumPage(driver);
		javavideo=new CoreJavaVideoPage(driver);
		contact=new ContactUsPage(driver);
	}
	
	@AfterMethod
	public  void methodTeardown() {
	
	web.quitBrowser();
}
	@AfterClass
	public void classTeardown() {
	excel.closeExcel();
	}
	//@AfterTest
	//@AfterSuite

	}


