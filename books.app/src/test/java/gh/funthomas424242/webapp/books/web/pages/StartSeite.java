package gh.funthomas424242.webapp.books.web.pages;

import gh.funthomas424242.webapp.books.domain.Book;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class StartSeite extends SeleniumPage {

	public static final String SERVER_URL = "http://localhost:";

	// @Value("${local.server.port}")
	protected int serverPort = 8080;

	@Override
	public String getPageUrl() {
		return SERVER_URL + serverPort + "/";
	}

	@FindBy(id = "erfasseBuch")
	WebElement buttonErfasseBuch;

	public void pressButtonErfasseBuch() {
		buttonErfasseBuch.click();
	}

	//@FindBys({ @FindBy(name = "tr"), @FindBy(name = "td") })
	@FindBy(name="tr")
	List<WebElement> buchListe;

	public int getBuchanzahl(){
		if( buchListe != null){
			return buchListe.size();
		}else{
			return -1;
		}
	}
	
	public List<Book> getBuchliste() {
		final List<Book> buecher=new ArrayList<Book>();
		for( final WebElement element:buchListe){
			System.out.println("TD: "+element.getText());
		}
		
		return buecher;
	}

}
