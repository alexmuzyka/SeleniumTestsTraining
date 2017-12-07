 package automationFramework;

 import org.testng.annotations.Test;
 import java.util.logging.Level;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;

 import org.apache.commons.logging.LogFactory;

 import com.gargoylesoftware.htmlunit.WebClient;
 import com.gargoylesoftware.htmlunit.html.HtmlElement;
 import com.gargoylesoftware.htmlunit.html.HtmlPage;

 public class CnnSearch {

 	@Test
 	public void CnnTests() throws Exception {
		
 		// Hiding of unnecessary logs
 		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
 		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
 		java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
		
 		final WebClient webClient = new WebClient();
 		final HtmlPage page = webClient.getPage("http://edition.cnn.com/search/?q=trump");
 		System.out.println("Web application launched");

 		// Waiting for loading page
 		Thread.sleep(7000);

 		HtmlElement element =(HtmlElement) page.getFirstByXPath("//*[contains(@class, 'results-count')]");
 		System.out.println("Search element found");
		
 		final String trumpSearchResult = element.asText();
		
 	    Pattern p = Pattern.compile("-?\\d{4,}");
 	    Matcher m = p.matcher(trumpSearchResult);
 	    while (m.find()) {
 	    	System.out.println("Number of mentions of Trump on the site cnn.com: " + m.group());
 	    }
	    
 		webClient.close();
 	}

 }
