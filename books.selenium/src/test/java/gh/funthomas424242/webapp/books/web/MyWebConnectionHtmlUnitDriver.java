package gh.funthomas424242.webapp.books.web;

import java.util.Locale;

import org.openqa.selenium.Capabilities;
import org.springframework.test.web.servlet.htmlunit.webdriver.WebConnectionHtmlUnitDriver;

import com.gargoylesoftware.htmlunit.WebClient;




public class MyWebConnectionHtmlUnitDriver extends WebConnectionHtmlUnitDriver {
	
	public MyWebConnectionHtmlUnitDriver(){
		super(true);
	}
	
	public MyWebConnectionHtmlUnitDriver(final Capabilities capabilities){
		super(capabilities);
	}
	
	public void changeLocaleTo(final Locale locale){
		final WebClient client = getWebClient();
		final String language=locale.getLanguage();
		client.addRequestHeader("Accept-Language" , language);
	}

	

}
