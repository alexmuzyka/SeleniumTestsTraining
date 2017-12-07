package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeltaComHomePage {

	private static WebElement element = null;

	public static WebElement lnk_Flight(WebDriver driver) {

		element = driver.findElement(By.id("book-air-content-trigger"));

		return element;

	}
	
	public static WebElement btn_RoundTrip(WebDriver driver) {

		element = driver.findElement(By.id("roundTripBtn"));

		return element;

	}
	
	public static WebElement btn_DepartureDate(WebDriver driver) {

		element = driver.findElement(By.id("depDateCalIcon"));

		return element;

	}
	
	public static WebElement btn_ReturnDate(WebDriver driver) {

		element = driver.findElement(By.id("retDateCalIcon"));

		return element;

	}
	
	public static List<WebElement> lnk_AllAvaliableCalendarDates(WebDriver driver) {

		List<WebElement> listElements = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));

		return listElements;

	}
	
	public static WebElement txtbx_From(WebDriver driver) {

		element = driver.findElement(By.id("originCity"));

		return element;

	}	
	
	public static WebElement txtbx_To(WebDriver driver) {

		element = driver.findElement(By.id("destinationCity"));

		return element;

	}	
	
	public static WebElement btn_FindFlights(WebDriver driver) {

		element = driver.findElement(By.id("findFlightsSubmit"));

		return element;

	}
	
}
