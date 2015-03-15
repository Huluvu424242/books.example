package gh.funthomas424242.webapp.books.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ErfasseBuchdatenPage extends SeleniumPage {
	
	@Override
	public String getPageUrl() {
		return "http://localhost:8080/book/add";
	}
	
	
	@FindBy(id = "registriereBuch")
	WebElement buttonRegistriereBuch;

	public void pressButtonRegistriereBuch() {
		buttonRegistriereBuch.click();
	}

	
	@FindBy(id="titel")
	protected WebElement inputTitel;
	
	@FindBy(id="isbn")
	protected WebElement inputISBN;
	
	public void setTitel(final String titel){
		inputTitel.sendKeys(titel);
	}

	
	public void setISBN(final String isbn){
		inputISBN.sendKeys(isbn);
	}

}
