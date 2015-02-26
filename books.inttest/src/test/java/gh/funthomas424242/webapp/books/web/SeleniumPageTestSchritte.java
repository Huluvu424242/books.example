package gh.funthomas424242.webapp.books.web;
//
//import gh.funthomas424242.webapp.books.AcceptanceTestsConfiguration;
//import gh.funthomas424242.webapp.books.Application;
//
//import java.io.IOException;
//
//import org.junit.Assert;
//import org.openqa.selenium.WebDriver;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.htmlunit.webdriver.MockMvcHtmlUnitDriver;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.de.Dann;
//import cucumber.api.java.de.Gegebensei;
//import cucumber.api.java.de.Wenn;
//
//@SpringApplicationConfiguration(classes = { Application.class })
//@WebAppConfiguration
//@ContextConfiguration(classes = AcceptanceTestsConfiguration.class)
//// @WebIntegrationTest
//// @IntegrationTest({ "server.port=0" })
//public class SeleniumPageTestSchritte {
//
//	@Autowired
//	protected WebApplicationContext context;
//
//	protected MockMvcHtmlUnitDriver driver;
//	// protected HtmlUnitDriver driver;
//
//	protected SeleniumPage page;
//
//	protected WebDriver getWebDriver() {
//		return this.driver;
//	}
//
//	@Before
//	public void setup() throws IOException {
//		final MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context)
//				.build();
//		driver = new MockMvcHtmlUnitDriver(mockMvc, true);
//		// driver = new HtmlUnitDriver();
//	}
//
//	@After
//	public void destroy() {
//		if (driver != null) {
//			driver.close();
//		}
//	}
//
//	@Gegebensei("^wir befinden uns auf der Startseite\\.$")
//	public void navigiereZurStartseite() throws Throwable {
//		final StartSeite startseite = new StartSeite(getWebDriver());
//		page = startseite.open();
//	}
//
//	@Wenn("^der Browser weitergeleitet hat\\.$")
//	public void der_Browser_weitergeleitet_hat() throws Throwable {
//		// nichts zu tun
//	}
//
//	@Dann("^lautet der URL \"(.*?)\"\\.$")
//	public void lautet_der_URL(String url) throws Throwable {
//		page = new StartSeite(getWebDriver());
//		Assert.assertTrue(page.isCurrentPage());
//		//Assert.assertEquals(url,page.getPageUrl());
//	}
//
//}
