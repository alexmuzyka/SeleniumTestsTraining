package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TutBySearchPage {
	
	private static WebElement element = null;
	private static List<WebElement> listElement = null;

	public static WebElement txtbx_SearchField(WebDriver driver) {

		element = driver.findElement(By.id("search_from_str"));

		return element;

	}

	public static WebElement btn_Search(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@class='button big']"));

		return element;

	}
	
	public static WebElement lnk_SearchResult(WebDriver driver) {

		element = driver.findElement(By.xpath("//h3/a[2]"));

		return element;

	}
	
	public static List<WebElement> lnk_AllSearchResults(WebDriver driver) {

		listElement = driver.findElements(By.xpath("//h3/a[2]"));
		
		return listElement;

	}

}
