package gh.funthomas424242.webapp.books.restapi;

import gh.funthomas424242.webapp.books.Application;
import guru.nidi.ramltester.RamlDefinition;
import guru.nidi.ramltester.RamlLoaders;
import guru.nidi.ramltester.SimpleReportAggregator;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringApplicationConfiguration(classes = { Application.class })
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class BooksRestAPITester {

	private static RamlDefinition api = RamlLoaders
			//.fromFile("src/test/resources")
			.fromClasspath(Application.class).load("restapi.raml")
			.assumingBaseUri("http://localhost8080/");
	
	private static SimpleReportAggregator aggregator=new SimpleReportAggregator();

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void retrieveBooks() throws Exception {
		mvc.perform(get("/books").accept(MediaType.parseMediaType("text/html")))
				.andExpect(api.matches().aggregating(aggregator))
				//.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

}
