package gh.funthomas424242.webapp.books.web;

import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.lib.Steps;
import gh.funthomas424242.webapp.books.web.pages.ErfasseBuchdatenPage;
import gh.funthomas424242.webapp.books.web.pages.SeleniumPage;
import gh.funthomas424242.webapp.books.web.pages.StartSeite;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;

@SpringApplicationConfiguration(classes = { Application.class })
@Steps
public class GuiStorySteps {

	protected SeleniumPage page;
	protected WebDriver driver;

	@BeforeStory
	public void setup() {
		final DesiredCapabilities capabilities = DesiredCapabilities
				.htmlUnitWithJs();
		driver = new HtmlUnitDriver(capabilities);
	}

	@AfterStory
	public void destroy() {
		if (driver != null) {
			driver.close();
		}
	}

	@Given("der Server ist gestartet")
	public void derServerIstGestartet() throws Throwable {
		Assert.assertNotNull(driver);
	}

	@When("wir den URL $url aufrufen")
	public void openURL(final String url) throws Throwable {
		final StartSeite startseite = PageFactory.initElements(driver, StartSeite.class);
		page = startseite.open(driver);
	}

	@Then("wird die Startseite angezeigt")
	public void lautet_der_URL() throws Throwable {
		final String url = driver.getCurrentUrl();
		System.out.println("INFO#Startseite:" + page);
		Assert.assertEquals(page.getPageUrl(), url);
	}
	
	@Given("wir befinden uns auf der Startseite")
	@Then("wird zur Startseite navigiert")
	public void atStartseite(){
		this.page=PageFactory.initElements(driver, StartSeite.class);
		Assert.assertEquals(page.getPageUrl(), driver.getCurrentUrl());
		
	}
	
	@When("wir die Schaltfläche $buttonText betätigen")
	@Alias("die Schaltfläche $buttonText betätigen")
	public void pressButton(final String buttonText){
		final StartSeite curPage=(StartSeite)page;
		curPage.pressButtonRegisterBook();
	}
	
	
	@Given("wir befinden uns auf der Erfassungsseite für Bücher")
	public void openBuchErfassungsSeite(){
		page=PageFactory.initElements(driver, ErfasseBuchdatenPage.class);
		page.open(driver);
	}
	
	@Then("wird zur Erfassungsseite für Bücher navigiert")
	public void atBuchErfassungsSeite(){
		page=PageFactory.initElements(driver, ErfasseBuchdatenPage.class);
		Assert.assertEquals(page.getPageUrl(),driver.getCurrentUrl());
	}
	
	@When("wir als Titel $titel eingeben")
	@Pending
	public void titelErfassen(final String titel){
		
	}
	
	@When("als ISBN $isbn erfassen")
	@Pending
	public void isbnErfassen(final String isbnraw){
		
	}
	
		
	@Then("in der Liste der Bücher ein Buch angezeigt")
	@Pending
	public void bookListContainsBook(){
		
	}
	
	@Then("mit Titel $titel")
	@Pending
	public void listContainsTitel(final String titel){
		
	}
	
	@Then("mit ISBN $isbnraw")
	@Pending
	public void listContainsISBN(final String isbnRaw)
	{
		
	}

}
