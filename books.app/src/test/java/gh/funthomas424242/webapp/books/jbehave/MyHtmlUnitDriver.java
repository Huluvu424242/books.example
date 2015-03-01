package gh.funthomas424242.webapp.books.jbehave;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.stereotype.Component;

@Component
public class MyHtmlUnitDriver extends HtmlUnitDriver{
	
	public MyHtmlUnitDriver(){
		super(true);
//		
//		final DesiredCapabilities capabilities = DesiredCapabilities
//				.htmlUnitWithJs();
//		// capabilities.setBrowserName(BrowserType.FIREFOX);
//		// capabilities.setJavascriptEnabled(true);
//		// capabilities.setPlatform(<platform>);
//		// capabilities.setVersion(<version>);
//		// driver = new HtmlUnitDriver(capabilities);
//		System.out.println("INFO#======== NEW DRIVER startet ==========");
//		return new HtmlUnitDriver(capabilities);
		
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

}
