package gh.funthomas424242.webapp.books.web;

import static org.junit.Assert.assertTrue;
import gh.funthomas424242.webapp.books.MyTestConfiguration;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MyTestConfiguration.class})
//@IntegrationTest({ "server.port=8080" })
@WebIntegrationTest({ "server.port=8080" })
//@ContextHierarchy({
//    @ContextConfiguration(classes = Application.class)
//   //, @ContextConfiguration(classes = AcceptanceTestsConfiguration.class)
//})

//@WebAppConfiguration
public class MyWebIntegrationTest {

	public static final String SERVER_URL = "http://127.0.0.1:";

	@Value("${local.server.port}")
	private int serverPort;

	@Value("${link.books}")
	private String LINK_BOOKS;

	@Value("${link.buch.erfassen}")
	private String LINK_BUCH_ERFASSEN;

	@Value("${message.buch.liste.leer}")
	private String MESSAGE_LEERES_REGAL;

	@Test
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
