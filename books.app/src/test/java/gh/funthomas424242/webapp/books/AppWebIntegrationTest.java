package gh.funthomas424242.webapp.books;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
//@IntegrationTest({ "server.port=8080" })
@WebIntegrationTest({ "server.port=8080" })
//@ContextHierarchy({
//    @ContextConfiguration(classes = Application.class)
//   //, @ContextConfiguration(classes = AcceptanceTestsConfiguration.class)
//})

//@WebAppConfiguration
public class AppWebIntegrationTest {

	public static final String SERVER_URL = "http://127.0.0.1:";

	@Value("${local.server.port}")
	private int serverPort;

	@Value("${link.books}")
	private String LINK_BOOKS;

	@Value("${link.buch.erfassen}")
	private String LINK_BUCH_ERFASSEN;

	@Value("${message.buch.liste.leer}")
	private String MESSAGE_LEERES_REGAL;
	
	
	@Autowired
	protected WebApplicationContext context;

	protected WebDriver driver;
	//protected MockMvcHtmlUnitDriver driver;
	// protected RemoteWebDriver driver;

	//protected SeleniumPage page;

	protected WebDriver getWebDriver() {
		return this.driver;
	}

	@Before
	public void setup() throws IOException {
		final MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.build();
		logInfo("Context:"+context);
		logInfo("MOck:"+mockMvc);
	//	driver = new MockMvcHtmlUnitDriver(mockMvc, true);
//		 driver =  new RemoteWebDriver(
//                 new URL("http://localhost:8080/"), 
//                 DesiredCapabilities.firefox());
		driver = new HtmlUnitDriver(true);
	}

	@After
	public void destroy() {
		if (driver != null) {
			driver.close();
		}
	}
	
	
	@Test
	public void seleniumTest(){
		logInfo("DRIVER:"+driver);
		logInfo(SERVER_URL + serverPort + LINK_BOOKS);
		driver.get(SERVER_URL + serverPort + LINK_BOOKS);
		logInfo(SERVER_URL + serverPort + LINK_BOOKS);
		logInfo("TITEL:"+driver.getTitle());
		logInfo("TITEL:"+driver.getPageSource());
		
	}
	

	@Test
	@Ignore
	public void homePage() {
		final TestRestTemplate restTemplate = new TestRestTemplate();
		
		logInfo(MESSAGE_LEERES_REGAL);
		final String pageContent=restTemplate
				.getForObject(
				SERVER_URL + serverPort + LINK_BOOKS, String.class);
		logInfo(pageContent);
		//TODO
//		assertTrue(pageContent.contains(
//				MESSAGE_LEERES_REGAL));
	}

	protected void logInfo(String text) {
		System.out.println("=============================");
		System.out.println("LOG-INFO:"+text);
		System.out.println("=============================");
	}

	@Test
	@Ignore
	public void addPage() {
		RestTemplate restTemplate = new RestTemplate();
		assertTrue(restTemplate.getForObject(
				SERVER_URL + serverPort + LINK_BUCH_ERFASSEN, String.class)
				.contains("Aktuell keine Bücher im Buchregal."));
	}

	@Test
	@Ignore
	public void health() {
		RestTemplate restTemplate = new RestTemplate();
		assertTrue(restTemplate.getForObject(
				SERVER_URL + serverPort + "/health", String.class).contains(
				"UP"));
	}

}
