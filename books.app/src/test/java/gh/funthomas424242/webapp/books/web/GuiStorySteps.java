package gh.funthomas424242.webapp.books.web;

import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.jbehave.Steps;
import gh.funthomas424242.webapp.books.web.pages.SeleniumPage;
import gh.funthomas424242.webapp.books.web.pages.StartSeite;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.test.SpringApplicationConfiguration;

@SpringApplicationConfiguration(classes = { Application.class })
@Steps
public class GuiStorySteps {

	protected SeleniumPage page;
	protected WebDriver driver;

	@BeforeStory
	public void setup() {
		final DesiredCapabilities capabilities = DesiredCapabilities
				.htmlUnitWithJs();
		driver = new HtmlUnitDriver(capabilities);
		// System.out.println("INFO#======== NEW DRIVER startet ==========");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@AfterStory
	public void destroy() {
		if (driver != null) {
			driver.close();
		}
	}

	@Given("der Server ist gestartet")
	public void derServerIstGestartet() throws Throwable {
		Assert.assertNotNull(driver);
	}

	@When("wir den URL $url aufrufen")
	public void openURL(final String url) throws Throwable {
		final StartSeite startseite = new StartSeite(driver);
		page = startseite.open();
	}

	@Then("wird die Startseite angezeigt")
	public void lautet_der_URL() throws Throwable {
		final String url = driver.getCurrentUrl();
		System.out.println("INFO#Startseite:" + page);
		Assert.assertEquals(page.getPageUrl(), url);
	}

}
