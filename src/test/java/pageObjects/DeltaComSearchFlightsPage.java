package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeltaComSearchFlightsPage {

	private static WebElement element = null;
	
	public static WebElement btn_DepartureDateIfWrongDate(WebDriver driver) {

		element = driver.findElement(By.id("depDateCalIconRt"));

		return element;

	}
	
	public static WebElement btn_ReturnDateIfWrongDate(WebDriver driver) {

		element = driver.findElement(By.id("retDateCalIconRt"));

		return element;

	}	
	
	public static WebElement btn_FindFlights(WebDriver driver) {

		element = driver.findElement(By.id("submitAdvanced"));

		return element;

	}	
	
}
