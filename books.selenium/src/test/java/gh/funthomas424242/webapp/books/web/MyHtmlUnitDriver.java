package gh.funthomas424242.webapp.books.web;

import java.util.Locale;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.WebClient;



public class MyHtmlUnitDriver extends HtmlUnitDriver {
	
	public MyHtmlUnitDriver(){
		super(true);
	}
	
	public MyHtmlUnitDriver(final Capabilities capabilities){
		super(capabilities);
	}
	
	public void changeLocaleTo(final Locale locale){
		final WebClient client = getWebClient();
		final String language=locale.getLanguage();
		client.addRequestHeader("Accept-Language" , language);
	}

	

}
