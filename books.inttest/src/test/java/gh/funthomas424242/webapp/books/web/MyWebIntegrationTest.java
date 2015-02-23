package gh.funthomas424242.webapp.books.web;

import static org.junit.Assert.*;
import gh.funthomas424242.webapp.books.Application;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@IntegrationTest({ "server.port=0" })
@WebAppConfiguration
public class MyWebIntegrationTest {

	public static final String SERVER_URL = "http://127.0.0.1:";

	@Value("${local.server.port}")
	private int serverPort;

	@Value("${link.books}")
	private String LINK_BOOKS;

	@Value("${link.buch.erfassen}")
	private String LINK_BUCH_ERFASSEN;

	// @Value("${message.buch.liste.leer}")
	private String MESSAGE_LEERES_REGAL = "Aktuell keine Bücher im Buchregal.";

	@Test
	public void homePage() {
		RestTemplate restTemplate = new RestTemplate();
		assertTrue(restTemplate.getForObject(
				SERVER_URL + serverPort + LINK_BOOKS, String.class).contains(
				MESSAGE_LEERES_REGAL));
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
