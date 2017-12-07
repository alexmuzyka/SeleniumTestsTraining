package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeltaComPassengerInfoPage {

	private static WebElement element = null;

	public static WebElement dd_Prefix(WebDriver driver) {

		element = driver.findElement(By.id("prefix0-button"));

		return element;

	}
	
	public static WebElement dd_PrefixSelect(WebDriver driver) {

		element = driver.findElement(By.id("//*[@id='ui-id-3']"));

		return element;

	}
	
	public static WebElement dd_Gender(WebDriver driver) {

		element = driver.findElement(By.id("gender0-button"));

		return element;

	}
	
	public static WebElement dd_MonthOfBirth(WebDriver driver) {

		element = driver.findElement(By.id("month0-button"));

		return element;

	}
	
	public static WebElement dd_DayOfBirth(WebDriver driver) {

		element = driver.findElement(By.id("day0-button"));

		return element;

	}
	
	public static WebElement dd_YearOfBirth(WebDriver driver) {

		element = driver.findElement(By.id("year0-button"));

		return element;

	}
	
	
	public static WebElement txtbx_FirstName(WebDriver driver) {

		element = driver.findElement(By.id("firstName0"));

		return element;

	}
	
	public static WebElement txtbx_LastName(WebDriver driver) {

		element = driver.findElement(By.id("lastName0"));

		return element;

	}
	
	public static WebElement txtbx_TelephoneNumber(WebDriver driver) {

		element = driver.findElement(By.id("telephoneNumber0"));

		return element;

	}
	
	public static WebElement txtbx_Email(WebDriver driver) {

		element = driver.findElement(By.id("email"));

		return element;

	}
	
	public static WebElement txtbx_ConfirmEmail(WebDriver driver) {

		element = driver.findElement(By.id("reEmail"));

		return element;

	}
	
	public static WebElement btn_No(WebDriver driver) {

		element = driver.findElement(By.xpath("//span[contains(text(), 'No')]"));

		return element;

	}
	
	public static WebElement btn_Continue(WebDriver driver) {

		element = driver.findElement(By.id("paxReviewPurchaseBtn"));

		return element;

	}
	
}
