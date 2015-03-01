package gh.funthomas424242.webapp.books.web.pages;

import org.openqa.selenium.WebDriver;

public class StartSeite extends SeleniumPage {

	public StartSeite(final WebDriver driver) {
		super(driver);
	}
	
	
	public static final String SERVER_URL = "http://127.0.0.1:";

	//@Value("${local.server.port}")
	private int serverPort=8080;

	@Override
	public String getPageUrl() {
		return SERVER_URL+serverPort+"/";
	}

}
