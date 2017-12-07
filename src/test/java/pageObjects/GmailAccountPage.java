package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ConstantsGmail;
import utility.Log;;

public class GmailAccountPage {

	private static WebElement element = null;

	public static WebElement txtbx_LoginName(WebDriver driver) {
		element = driver.findElement(By.id("identifierId"));
		Log.info("Login Name text box found");
		return element;
	}
	
	public static WebElement txtbx_Password(WebDriver driver) {
		element = driver.findElement(By.id(ConstantsGmail.XPATH_PASSWORD));
		Log.info("Password text box found");
		return element;
	}

	public static WebElement btn_IdentifierNext(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='identifierNext']/content"));
		Log.info("Identifier Next button found");
		return element;
	}
	
	public static WebElement btn_PasswordNext(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='passwordNext']/content"));
		Log.info("Password Next text box found");
		return element;
	}
	
	public static WebElement txt_Email(WebDriver driver) {
		element = driver.findElement(By.id(ConstantsGmail.XPATH_TEXT_EMAIL));
		Log.info("Email text found");
		return element;
	}
	
}
