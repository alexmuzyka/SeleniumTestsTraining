package appModule;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.GmailAccountPage;
import pageObjects.GmailHomePage;
import utility.ConstantsGmail;
import utility.Log;

public class GmailHelperMethods {
	
	public static void SingIn(WebDriver driver, String sUseremail, String sPassword) {
		
		GmailAccountPage.txtbx_LoginName(driver).sendKeys(ConstantsGmail.USERNAME);
		Log.info("Username entered in the Login Name text box");
		
		GmailAccountPage.btn_IdentifierNext(driver).click();
		Log.info("Click action performed on Identifier Next button");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsGmail.XPATH_PASSWORD)));
		Log.info("Wait until new page with password field loaded");
		
		Assert.assertEquals(GmailAccountPage.txt_Email(driver).getText(), sUseremail);
		Log.info("Verify user email text presented");

		GmailAccountPage.txtbx_Password(driver).sendKeys(sPassword);
		Log.info("Password entered in the Password text box");

		GmailAccountPage.btn_PasswordNext(driver).click();
		Log.info("Click action performed on Password Next button");
	}
	
	public static void TestEmailFolders(WebDriver driver) {
		
		GmailHomePage.lnk_Sent(driver).click();
		Log.info("Click action performed on Sent link");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlMatches(ConstantsGmail.GMAIL_SEND_URL));
		Log.info("Wait until new page loaded");
		
		Assert.assertEquals(url_CurrentUrl(driver), ConstantsGmail.GMAIL_SEND_URL);
		Log.info("Verify page loaded with correct info");

		GmailHomePage.lnk_Expand(driver).click();
		Log.info("Click action performed on Expand link");
		
		wait.until(ExpectedConditions.visibilityOf(GmailHomePage.lnk_Spam(driver)));
		Log.info("Wait until new page loaded");
		
		GmailHomePage.lnk_Spam(driver).click();
		Log.info("Click action performed on Spam link");
		
		wait.until(ExpectedConditions.urlMatches(ConstantsGmail.GMAIL_SPAM_URL));
		Log.info("Wait until new page loaded");
		
		Assert.assertEquals(url_CurrentUrl(driver), ConstantsGmail.GMAIL_SPAM_URL);
		Log.info("Verify page loaded with correct info");

		GmailHomePage.lnk_Inbox(driver).click();
		Log.info("Click action performed on Inbox link");
		
		Assert.assertEquals(url_CurrentUrl(driver), ConstantsGmail.GMAIL_INBOX_URL);
		Log.info("Verify page loaded with correct info");
	}
	
	public static void TestEmailSearchFields(WebDriver driver) {
		
		GmailHomePage.txtbx_SearchField(driver).clear();
		Log.info("Clear Search Field text box");
		
		GmailHomePage.txtbx_SearchField(driver).sendKeys(ConstantsGmail.GMAIL_SEARCH_TEXT);
		Log.info("Search text entered in the Search Field text box");

		GmailHomePage.btn_Search(driver).click();
		Log.info("Click action performed on Search button");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.urlContains(ConstantsGmail.GMAIL_SEARCH_URL));
		Log.info("Wait until new page loaded");
		
		Assert.assertEquals(GmailHomePage.tbl_Line(driver).size(), 2);
		Log.info("Verify page loaded with correct info");
		
		List<String> strings = new ArrayList<String>();
		for (WebElement e : GmailHomePage.tbl_LineElem(driver)) {
			strings.add(e.getText());
		}
		System.out.print("List of results: " + strings + "\n");
		
	}
	
	public static void TestCreateAndSendEmail(WebDriver driver) {
		
		GmailHomePage.btn_WriteEmail(driver).click();
		Log.info("Click action performed on Write Email button");
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(GmailHomePage.txtbx_EmailTo(driver)));
		Log.info("Wait until new page loaded");

		GmailHomePage.txtbx_EmailTo(driver).sendKeys(ConstantsGmail.USER_EMAIL);
		Log.info("'User Email' entered in the 'Email To' text box");
		
		GmailHomePage.txtbx_EmailTo(driver).sendKeys(Keys.RETURN);
		Log.info("Enter key clicked");
		
		GmailHomePage.txtbx_EmailSubject(driver).sendKeys(ConstantsGmail.GMAIL_EMAIL_SUBJECT);
		Log.info("Subject entered in the Email Subject text box");
		
		GmailHomePage.txtbx_EmailText(driver).sendKeys(ConstantsGmail.GMAIL_EMAIL_TEXT);
		Log.info("Text entered in the Email Boby text box");
		
		GmailHomePage.btn_Send(driver).click();
		Log.info("Click action performed on Send button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsGmail.ID_LINK_SENT_EMAIL)));
		Log.info("Wait until new page loaded");
		
	}

	public static void LogOut(WebDriver driver) {
		
		GmailHomePage.lnk_Account(driver).click();
		Log.info("Click action performed on Account link");
		
		GmailHomePage.btn_Logout(driver).click();
		Log.info("Click action performed on Logout link");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ConstantsGmail.XPATH_PASSWORD)));
		Log.info("Wait until new page loaded");
		
		Assert.assertEquals(GmailAccountPage.txt_Email(driver).getText(), ConstantsGmail.USER_EMAIL);
		Log.info("Verify page loaded with correct info");
	}
	
	public static String url_CurrentUrl(WebDriver driver) {
		String url = driver.getCurrentUrl();
		return url;
	}
	
}
