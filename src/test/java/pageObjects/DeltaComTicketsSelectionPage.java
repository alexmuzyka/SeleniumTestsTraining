package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ConstantsDeltaCom;

public class DeltaComTicketsSelectionPage {

	private static WebElement element = null;

	public static WebElement lnk_SelectTicket(WebDriver driver) {

		element = driver.findElement(By.xpath(ConstantsDeltaCom.XPATH_LINK_SELECT_TICKET));

		return element;

	}
	
}
