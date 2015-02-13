package gh.funthomas424242.webapp.books.tests;

import static org.junit.Assert.assertTrue;
import gh.funthomas424242.webapp.books.Application;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@PropertySource("classpath:messages.properties")
@IntegrationTest({"server.port=0"})
@WebAppConfiguration
public class WebIntegrationTest {

	public static final String SERVER_URL = "http://127.0.0.1:";
	
	@Value("${local.server.port}")
	private int serverPort;

	//@Value("${message.buch.liste.leer}")
	private String messageLeeresRegal="Aktuell keine Bücher im Buchregal.";
	
	@Test
	public void homePage() {
		RestTemplate restTemplate = new RestTemplate();
		assertTrue(restTemplate.getForObject(SERVER_URL+serverPort+"/books",
				String.class).contains( messageLeeresRegal));
	}

	@Test
	@Ignore
	public void addPage() {
		RestTemplate restTemplate = new RestTemplate();
		assertTrue(restTemplate.getForObject(SERVER_URL+serverPort+"/book/add",
				String.class).contains("Aktuell keine Bücher im Buchregal."));
	}
	
	@Test
	@Ignore
	public void health() {
		RestTemplate restTemplate = new RestTemplate();
		assertTrue(restTemplate.getForObject(SERVER_URL+serverPort+"/health",
				String.class).contains("UP"));
	}

}
