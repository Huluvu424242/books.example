package gh.funthomas424242.webapp.books.web;

import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.domain.InvalidISBNException;
import gh.funthomas424242.webapp.books.lib.Steps;
import gh.funthomas424242.webapp.books.web.pages.ErfasseBuchdatenPage;
import gh.funthomas424242.webapp.books.web.pages.SeleniumPage;
import gh.funthomas424242.webapp.books.web.pages.StartSeite;

import java.util.List;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
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
		driver.get(url);
	}

	@Given("wir befinden uns auf der Startseite")
	public void openStartseite() {
		this.page = PageFactory.initElements(driver, StartSeite.class);
		page.open(driver);
	}

	@When("wir die Schaltfläche zum Erfassen eines Buches betätigen")
	public void pressButtonErfasseBuch() {
		final StartSeite curPage = (StartSeite) page;
		curPage.pressButtonErfasseBuch();
	}

	@When("die Schaltfläche zum Buch registrieren betätigen")
	public void pressButtonRegistriereBuch() {
		final ErfasseBuchdatenPage curPage = (ErfasseBuchdatenPage) page;
		curPage.pressButtonRegistriereBuch();
	}

	@Given("wir befinden uns auf der Erfassungsseite für Bücher")
	public void openBuchErfassungsSeite() {
		page = PageFactory.initElements(driver, ErfasseBuchdatenPage.class);
		page.open(driver);
	}

	@When("wir als Titel $titel eingeben")
	public void titelErfassen(final String titel) {
		final ErfasseBuchdatenPage curPage = (ErfasseBuchdatenPage) page;
		curPage.setTitel(titel);
	}

	@When("als ISBN $isbn erfassen")
	public void isbnErfassen(final String isbn) {
		final ErfasseBuchdatenPage curPage = (ErfasseBuchdatenPage) page;
		curPage.setISBN(isbn);
	}

	@Then("in der Liste der Bücher ein Buch angezeigt")
	public void bookListContainsBook() {
		final StartSeite curPage = (StartSeite) page;
		Assert.assertTrue(curPage.getBuchanzahl() > 0);
		final List<Book> buchListe = curPage.getBuchliste();
		Assert.assertNotNull(buchListe);

	}

	@Then("mit Titel $titel")
	public void listContainsTitel(final String titel) {
		final StartSeite curPage = (StartSeite) page;
		final List<Book> buchListe = curPage.getBuchliste();
		final String buchTitel=buchListe.get(0).getTitel();
		Assert.assertEquals(titel, buchTitel);
	}

	@Then("mit ISBN $isbnraw")
	public void listContainsISBN(final String isbnRaw) {
		final StartSeite curPage = (StartSeite) page;
		final List<Book> buchListe = curPage.getBuchliste();
		final ISBN isbn=buchListe.get(0).getIsbn();
		try {
			Assert.assertEquals(ISBN.parseFromString(isbnRaw), isbn);
		} catch (InvalidISBNException e) {
			Assert.fail();
		}
	}

	@Then("wird auf die Startseite weitergeleitet")
	@Alias("wird zur Startseite navigiert")
	public void atStartseite() {
		this.page = PageFactory.initElements(driver, StartSeite.class);
		Assert.assertEquals(page.getPageUrl(), driver.getCurrentUrl());

	}

	@Then("wird zur Erfassungsseite für Bücher navigiert")
	public void atBuchErfassungsSeite() {
		page = PageFactory.initElements(driver, ErfasseBuchdatenPage.class);
		Assert.assertEquals(page.getPageUrl(), driver.getCurrentUrl());
	}

}
