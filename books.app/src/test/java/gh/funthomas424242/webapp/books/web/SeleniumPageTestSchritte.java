package gh.funthomas424242.webapp.books.web;

import gh.funthomas424242.webapp.books.web.pages.SeleniumPage;
import gh.funthomas424242.webapp.books.web.pages.StartSeite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;

import cucumber.api.java.de.Angenommen;
import cucumber.api.java.de.Dann;
import cucumber.api.java.de.Wenn;

@SpringApplicationConfiguration(classes = { GuiIntegrationTest.class })
@WebIntegrationTest({ "server.port=8080" })
public class SeleniumPageTestSchritte {

	protected SeleniumPage page;
	final protected WebDriver driver = new HtmlUnitDriver(true);

	//
	// @Before
	// public void setup() throws IOException {
	//
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	// }

	// @After
	// public void destroy() {
	// if (driver != null) {
	// driver.close();
	// }
	// }

	@Angenommen("^wir befinden uns auf der Startseite\\.$")
	public void navigiereZurStartseite() throws Throwable {
		// driver.get("http://127.0.0.1:8080/");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		// final String url = driver.getCurrentUrl();
		// System.out.println("INFO_URL:"+url);
		final StartSeite startseite = new StartSeite(driver);
		page = startseite.open();
	}

	@Wenn("^der Browser weitergeleitet hat\\.$")
	public void der_Browser_weitergeleitet_hat() throws Throwable {
		// nichts zu tun
	}

	@Dann("^lautet der URL \"(.*?)\"\\.$")
	public void lautet_der_URL(String url1) throws Throwable {
		// final String url = driver.getCurrentUrl();
		 
		//Assert.assertTrue(page.isCurrentPage());
		// Assert.assertEquals(url,page.getPageUrl());
	}

}
