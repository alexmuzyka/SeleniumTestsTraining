package automationFramework;

import org.testng.annotations.Test;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.DeltaComHomePage;
import pageObjects.DeltaComPassengerInfoPage;
import pageObjects.DeltaComReviewFlightPage;
import pageObjects.DeltaComSearchFlightsPage;
import pageObjects.DeltaComTicketsSelectionPage;
import pageObjects.DeltaComTripSummaryPage;
import utility.ConstantsDeltaCom;
import utility.Log;

public class DeltaCom {

	private static WebDriver driver = null;
	
	@BeforeMethod

	public void beforeMethod() {

		DOMConfigurator.configure("log4j.xml");

		Log.startTestCase("Selenium_Test_DeltaCom");
		
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		
		driver = new FirefoxDriver();
		Log.info("New driver instantiated");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");

		driver.get(ConstantsDeltaCom.DELTA_URL);
		Log.info("Web application launched");

	}
	
	@Test

	public void DeltaComTests() throws InterruptedException {
		
		DeltaComHomePage.lnk_Flight(driver).click();
		Log.info("Click action performed on Flight link");
		
		DeltaComHomePage.btn_RoundTrip(driver).click();
		Log.info("Click action performed on Round Trip button");
		
		DeltaComHomePage.txtbx_From(driver).clear();
		Log.info("Clear Search Field text box");

		DeltaComHomePage.txtbx_From(driver).sendKeys(ConstantsDeltaCom.JFK_AIRPORT);
		Log.info("Search text entered in the Search Field text box");
		
		DeltaComHomePage.txtbx_To(driver).sendKeys(ConstantsDeltaCom.SVO_AIRPORT);
		Log.info("Search text entered in the Search Field text box");
		
		DeltaComHomePage.btn_DepartureDate(driver).click();
		Log.info("Click action performed on Departure Date button");

		int randomNum = ThreadLocalRandom.current().nextInt(1, 29);
		DeltaComHomePage.lnk_AllAvaliableCalendarDates(driver).get(randomNum).click();
		Log.info("Select date");
		
		DeltaComHomePage.btn_ReturnDate(driver).click();
		Log.info("Click action performed on btn_Return Date button");
		
		DeltaComHomePage.lnk_AllAvaliableCalendarDates(driver).get(randomNum).click();
		Log.info("Select date");
		
		DeltaComHomePage.btn_FindFlights(driver).click();
		Log.info("Click action performed on Find Flights button");
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ConstantsDeltaCom.XPATH_LINK_FLIGHTS_HEADER)));
		Log.info("Wait until new page loaded");
		
		if (driver.getPageSource().contains("Oh no! We're sorry")) {
			Log.info("There is no flights on this dates");
			
			DeltaComSearchFlightsPage.btn_DepartureDateIfWrongDate(driver).click();
			Log.info("Click action performed on Departure Date button");

			DeltaComHomePage.lnk_AllAvaliableCalendarDates(driver).get(randomNum).click();
			Log.info("Select date");
			
			DeltaComSearchFlightsPage.btn_ReturnDateIfWrongDate(driver).click();
			Log.info("Click action performed on btn_Return Date button");
			
			DeltaComHomePage.lnk_AllAvaliableCalendarDates(driver).get(randomNum).click();
			Log.info("Select date");
			
			DeltaComSearchFlightsPage.btn_FindFlights(driver).click();
			Log.info("Click action performed on Find Flights button");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ConstantsDeltaCom.XPATH_LINK_SELECT_TICKET)));
		}
		
		DeltaComTicketsSelectionPage.lnk_SelectTicket(driver).click();
		Log.info("Click action performed on Select Ticket link");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ConstantsDeltaCom.XPATH_LINK_SELECT_TICKET)));
		Thread.sleep(500);
		Log.info("Wait until new page loaded");
		
		DeltaComTicketsSelectionPage.lnk_SelectTicket(driver).click();
		Log.info("Click action performed on Select Ticket link");

		DeltaComTripSummaryPage.btn_Continue(driver).click();
		Log.info("Click action performed on Continue button");
	
		DeltaComPassengerInfoPage.dd_Prefix(driver).sendKeys(ConstantsDeltaCom.PREFIX);
		Log.info("Data entered in the Prefix text box");
		
		DeltaComPassengerInfoPage.txtbx_FirstName(driver).sendKeys(ConstantsDeltaCom.FIRST_NAME);
		Log.info("Data entered in the First Name text box");
		
		DeltaComPassengerInfoPage.txtbx_LastName(driver).sendKeys(ConstantsDeltaCom.LAST_NAME);
		Log.info("Data entered in the Last Name text box");
		
		DeltaComPassengerInfoPage.dd_Gender(driver).sendKeys(ConstantsDeltaCom.GENDER);
		Log.info("Data entered in the Gender text box");
		
		DeltaComPassengerInfoPage.dd_MonthOfBirth(driver).sendKeys(ConstantsDeltaCom.MONTH_OF_BIRTH);
		Log.info("Data entered in the Month Of Birth dropdown");
		
		DeltaComPassengerInfoPage.dd_DayOfBirth(driver).sendKeys(ConstantsDeltaCom.DAY_OF_BIRTH);
		Log.info("Data entered in the Day Of Birth dropdown");
		
		DeltaComPassengerInfoPage.dd_YearOfBirth(driver).sendKeys(ConstantsDeltaCom.YEAR_OF_BIRTH);
		Log.info("Data entered in the Year Of Birth dropdown");
		
		DeltaComPassengerInfoPage.btn_No(driver).click();
		Log.info("Click action performed on No button");
		
		DeltaComPassengerInfoPage.txtbx_TelephoneNumber(driver).sendKeys(ConstantsDeltaCom.TELEPHONE_NUMBER);
		Log.info("Data entered in the Telephone Number text box");
		
		DeltaComPassengerInfoPage.txtbx_Email(driver).sendKeys(ConstantsDeltaCom.EMAIL);
		Log.info("Data entered in the Email text box");
		
		DeltaComPassengerInfoPage.txtbx_ConfirmEmail(driver).sendKeys(ConstantsDeltaCom.CONFIRM_EMAIL);
		Log.info("Data entered in the Confirm Email text box");
		
		DeltaComPassengerInfoPage.btn_Continue(driver).click();
		Log.info("Click action performed on Continue button");
		
		if (DeltaComReviewFlightPage.btn_CompletePurchase(driver).isEnabled()) {
			System.out.println("Complete Purchase button is enabled");
		}
	}
	
	@AfterMethod

	public void afterMethod() {
		
		driver.quit(); 
		Log.info("Browser closed");
		Log.endTestCase("Selenium_Test_DeltaCom");
	}

}
