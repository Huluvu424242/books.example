package gh.funthomas424242.webapp.books.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartSeite extends SeleniumPage {

	
	
	public static final String SERVER_URL = "http://localhost:";

	//@Value("${local.server.port}")
	private int serverPort=8080;

	@Override
	public String getPageUrl() {
		return SERVER_URL+serverPort+"/";
	}

	@FindBy(id="erfasseBook")
	WebElement buttonRegisterBook;
	
	public void pressButtonRegisterBook(){
		buttonRegisterBook.click();
	}
	
}
