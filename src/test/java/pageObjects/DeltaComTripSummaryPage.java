package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeltaComTripSummaryPage {

	private static WebElement element = null;

	public static WebElement btn_Continue(WebDriver driver) {

		element = driver.findElement(By.id("tripSummarySubmitBtn"));

		return element;

	}
	
}
