package gh.funthomas424242.webapp.books.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import gh.funthomas424242.webapp.books.Application;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author huluvu424242
 * 
 *         Fixer GUI Test der bei jedem Modultest mitläuft. Soll extrem kurz
 *         gehalten werden und nur grundlegende Dinge sicherstellen. Beispiele:
 *         - Der Server startet - Die Startseite wird ausgeliefert. - Das
 *         JavaScript arbeitet korrekt (ein dyn. Text muss erkannt werden).
 * 
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
// WebConfiguration.class })
// @WebAppConfiguration
@DirtiesContext
@WebIntegrationTest({ "server.port=8080" })
@SeleniumTest(lang = SeleniumTest.LANGUAGE.DEUTSCH, baseUrl = "http://localhost:8080")
// @PropertySource("classpath:messages.properties")
public class ManualGuiIntegrationTest {

	public static final String SERVER_URL = "http://localhost:";

	@Value("${local.server.port}")
	private int serverPort;

	@Value("${link.books}")
	private String LINK_BOOKS;

	@Value("${link.buch.erfassen}")
	private String LINK_BUCH_ERFASSEN;

	@Value("${info.app.name}")
	private String APP_INFO;

	@Autowired
	protected WebDriver driver;

	@Autowired
	WebApplicationContext contextWebApp;

	// @Before
	// public void setup() throws IOException {
	//
	// final MyWebConnectionHtmlUnitDriver newDriver = new
	// MyWebConnectionHtmlUnitDriver();
	// newDriver.changeLocaleTo(Locale.GERMAN);
	// driver = MockMvcHtmlUnitDriverBuilder.webAppContextSetup(contextWebApp)
	// .configureDriver(newDriver);
	// }

	// @After
	// public void destroy() {
	// if (driver != null) {
	// driver.close();
	// }
	// }

	@Test
	public void startSeiteGeliefertJavaScriptArbeitet() {
		System.out
				.println("INFO_URL++:" + SERVER_URL + serverPort + LINK_BOOKS);
		driver.get(SERVER_URL + serverPort + LINK_BOOKS);
		assertEquals("Books.App", driver.getTitle());
		final WebElement element = driver.findElement(By.id("message"));
		final String messageCode = element.getText();
		// assertEquals("Aktuell keine Bücher im Buchregal.",
		// element.getText());
	}

	@Test
	///@Ignore
	public void homePage() {
		System.out.println("INFO: " + SERVER_URL + serverPort + LINK_BOOKS);
		final TestRestTemplate restTemplate = new TestRestTemplate();
		final String pageContent = restTemplate.getForObject(SERVER_URL
				+ serverPort + LINK_BOOKS, String.class);
		assertTrue(pageContent
				.contains("Kleine Bücherverwaltung - Bücherregal"));
	}

}
