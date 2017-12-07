package automationFramework;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import appModule.GmailHelperMethods;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import utility.ConstantsGmail;
import utility.Log;

public class Gmail {

	public WebDriver driver;

	@BeforeMethod

	public void beforeMethod() {

		DOMConfigurator.configure("log4j.xml");

		Log.startTestCase("Selenium_Test_Gmail");

		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

		driver = new FirefoxDriver();
		Log.info("New driver instantiated");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");

		driver.get(ConstantsGmail.GMAIL_URL);
		Log.info("Web application launched");

	}

	@Test

	public void GmailTests() {

		GmailHelperMethods.SingIn(driver, ConstantsGmail.USER_EMAIL, ConstantsGmail.PASSWORD);
		System.out.println("Test Login Passed");

		GmailHelperMethods.TestEmailFolders(driver);
		System.out.println("Test Email Folders Passed");

		GmailHelperMethods.TestEmailSearchFields(driver);
		System.out.println("Test Email Search Fields Passed");

		GmailHelperMethods.TestCreateAndSendEmail(driver);
		System.out.println("Test Create And Send Email Passed");

		GmailHelperMethods.LogOut(driver);
		System.out.println("Test Log Out Passed");
	}

	@AfterMethod

	public void afterMethod() {

		driver.quit();
		Log.info("Browser closed");
		Log.endTestCase("Selenium_Test_Gmail");

	}

}