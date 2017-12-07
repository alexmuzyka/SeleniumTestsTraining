package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TutByHomePage {

	private static WebElement element = null;

	public static WebElement txtbx_SearchField(WebDriver driver) {

		element = driver.findElement(By.id("search_from_str"));

		return element;

	}

	public static WebElement btn_Search(WebDriver driver) {

		element = driver.findElement(By.name("search"));

		return element;

	}

}
