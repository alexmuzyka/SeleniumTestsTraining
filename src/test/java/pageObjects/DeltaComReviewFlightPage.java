package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeltaComReviewFlightPage {

	private static WebElement element = null;

	public static WebElement btn_CompletePurchase(WebDriver driver) {

		element = driver.findElement(By.id("continue_button"));

		return element;

	}
	
}
