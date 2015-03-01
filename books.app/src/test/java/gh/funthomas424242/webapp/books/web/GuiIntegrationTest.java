package gh.funthomas424242.webapp.books.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import gh.funthomas424242.webapp.books.Application;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
@DirtiesContext
@WebIntegrationTest({ "server.port=8080" })
public class GuiIntegrationTest {
	
	
	public static final String SERVER_URL = "http://127.0.0.1:";

	@Value("${local.server.port}")
	private int serverPort;

	@Value("${link.books}")
	private String LINK_BOOKS;

	@Value("${link.buch.erfassen}")
	private String LINK_BUCH_ERFASSEN;

	@Value("${message.buch.liste.leer}")
	private String MESSAGE_LEERES_REGAL;

	static protected WebDriver driver;

	@BeforeClass
	public static void setup() throws IOException {
		driver = new HtmlUnitDriver(true);
	}

	@AfterClass
	public static void destroy() {
		if (driver != null) {
			driver.close();
		}
	}

	@Test
	public void startSeiteGeliefertJavaScriptArbeitet() {
		System.out.println("INFO_URL++:"+SERVER_URL + serverPort + LINK_BOOKS);
		driver.get(SERVER_URL + serverPort + LINK_BOOKS);
		assertEquals("Kleine Bücherverwaltung - Bücherregal", driver.getTitle());
		final WebElement element = driver.findElement(By.id("message"));
		assertEquals("Aktuell keine Bücher im Buchregal.", element.getText());
	}

	@Test
	public void homePage() {
		final TestRestTemplate restTemplate = new TestRestTemplate();
		final String pageContent = restTemplate.getForObject(SERVER_URL
				+ serverPort + LINK_BOOKS, String.class);
		assertTrue(pageContent
				.contains("Kleine Bücherverwaltung - Bücherregal"));
	}

}
