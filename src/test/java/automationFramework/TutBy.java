package automationFramework;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

// Import package pageObject.*
import pageObjects.TutByHomePage;
import pageObjects.TutBySearchPage;
import utility.ConstantsTutBy;
import utility.Log;

public class TutBy{

	private static WebDriver driver = null;
	
	@BeforeMethod

	public void beforeMethod() {
		
		DOMConfigurator.configure("log4j.xml");

		Log.startTestCase("Selenium_Test_TutBy");
		
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		
		driver = new FirefoxDriver();
		Log.info("New driver instantiated");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		
		driver.get(ConstantsTutBy.TUT_BY_URL);
		Log.info("Web application launched");
	}
	
	@Test

	public void TutByTests() {
		
		// Use page Object library now
		TutByHomePage.txtbx_SearchField(driver).sendKeys(ConstantsTutBy.SEARCH_TEXT_1);
		Log.info("Search text entered in the Search Field text box");

		TutByHomePage.btn_Search(driver).click();
		Log.info("Click action performed on Search button");

		System.out.println("Quantity of found links with search text \"" + ConstantsTutBy.SEARCH_TEXT_1 + 
				"\": " + TutBySearchPage.lnk_AllSearchResults(driver).size());
		
		TutBySearchPage.txtbx_SearchField(driver).clear();
		Log.info("Clear Search Field text box");
		
		TutBySearchPage.txtbx_SearchField(driver).sendKeys(ConstantsTutBy.SEARCH_TEXT_2);
		Log.info("Search text entered in the Search Field text box");
		
		TutBySearchPage.btn_Search(driver).click();
		Log.info("Click action performed on Search button");
		
		try {
			String link = TutBySearchPage.lnk_SearchResult(driver).getAttribute(ConstantsTutBy.ATTRIBUTE_HREF);
			System.out.println("Testing url: " + link);
			driver.get(link);
			AssertJUnit.assertEquals(driver.getCurrentUrl(), link);
			System.out.println("Opened url: " + driver.getCurrentUrl());
		} catch(Exception e) {
			System.out.println("No such page found");
		}
	}
	
	@AfterMethod

	public void afterMethod() {
		
		driver.quit();
		Log.info("Browser closed");
		Log.endTestCase("Selenium_Test_TutBy");
	}

}
