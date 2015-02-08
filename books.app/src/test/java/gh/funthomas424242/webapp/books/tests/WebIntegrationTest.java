package gh.funthomas424242.webapp.books.tests;

import static org.junit.Assert.assertTrue;
import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.web.BookController;

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
@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest("server.port=0")
@WebAppConfiguration
public class WebIntegrationTest {

	public static final String SERVER_URL = "http://127.0.0.1:";
	
	@Value("${local.server.port}")
	private int serverPort;

	
	@Test
	public void homePage() {
		RestTemplate restTemplate = new RestTemplate();
		assertTrue(restTemplate.getForObject(SERVER_URL+serverPort+"/books",
				String.class).contains("No messages"));
	}

	@Test
	@Ignore
	public void addPage() {
		RestTemplate restTemplate = new RestTemplate();
		assertTrue(restTemplate.getForObject(SERVER_URL+serverPort+"/book/add",
				String.class).contains("No messages"));
	}
	
	@Test
	@Ignore
	public void health() {
		RestTemplate restTemplate = new RestTemplate();
		assertTrue(restTemplate.getForObject(SERVER_URL+serverPort+"/health",
				String.class).contains("UP"));
	}

}
