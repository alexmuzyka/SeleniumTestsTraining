package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ConstantsGmail;
import utility.Log;

public class GmailHomePage {

	private static WebElement element = null;

	public static WebElement btn_WriteEmail(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id]/div[@class]/div[@role='button']"));
		Log.info("Write Email button found");
		return element;
	}
	
	public static WebElement lnk_Inbox(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(@href,'/#inbox')]"));
		Log.info("Inbox link found");
		return element;
	}
	
	public static WebElement lnk_Sent(WebDriver driver) {
		element = driver.findElement(By.xpath(ConstantsGmail.XPATH_LINK_SENT));
		Log.info("Sent link found");
		return element;
	}
	
	public static WebElement lnk_Spam(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(@href,'spam')]"));
		Log.info("Spam link found");
		return element;
	}
	
	public static WebElement lnk_Expand(WebDriver driver) {
		element = driver.findElement(By.xpath("//span/span"));
		Log.info("Expand link found");
		return element;
	}
	
	public static List<WebElement> tbl_Line(WebDriver driver) {
		List<WebElement> listElement = driver.findElements(By.xpath("//div[4]/div[4]//tbody/tr"));
		Log.info("Table lines found");
		return listElement;
	}
	
	public static List<WebElement> tbl_LineElem(WebDriver driver) {
		List<WebElement> listElement = driver.findElements(By.xpath("//div[4]/div[4]//tbody/tr/td"));
		Log.info("Table line elements found");
		return listElement;
	}
	
	public static WebElement txtbx_SearchField(WebDriver driver) {
		element = driver.findElement(By.xpath("//form//td//input"));
		Log.info("Search Field text box found");
		return element;
	}
	
	public static WebElement btn_Search(WebDriver driver) {
		element = driver.findElement(By.xpath("//button/span"));
		Log.info("Search button found");
		return element;
	}
	
	public static WebElement txtbx_EmailTo(WebDriver driver) {
		element = driver.findElement(By.xpath("//textarea[@name='to']"));
		Log.info("Email To text box found");
		return element;
	}
	
	public static WebElement txtbx_EmailSubject(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='subjectbox']"));
		Log.info("Email Subject text box found");
		return element;
	}
	
	public static WebElement txtbx_EmailText(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@role='textbox']"));
		Log.info("Email body text box found");
		return element;
	}
	
	public static WebElement btn_Send(WebDriver driver) {
		element = driver.findElement(By.xpath(ConstantsGmail.XPATH_BUTTON_SEND));
		Log.info("Send button found");
		return element;
	}
	
	public static WebElement lnk_Account(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(@href,'SignOutOptions')]"));
		Log.info("Account link found");
		return element;
	}
	
	public static WebElement btn_Logout(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(@href,'Logout')]"));
		Log.info("Logout button found");
		return element;
	}	
	
}
