package gh.funthomas424242.webapp.books.web;

import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.lib.MyHtmlUnitDriver;
import gh.funthomas424242.webapp.books.lib.Steps;
import gh.funthomas424242.webapp.books.web.pages.SeleniumPage;
import gh.funthomas424242.webapp.books.web.pages.StartSeite;

import java.util.Locale;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.test.SpringApplicationConfiguration;

@SpringApplicationConfiguration(classes = { Application.class })
@Steps
public class GuiInternationalisierungsStorySteps {

	protected SeleniumPage page;
	protected MyHtmlUnitDriver driver;

	@BeforeStory
	public void setup() {
		final DesiredCapabilities capabilities = DesiredCapabilities
				.htmlUnitWithJs();
		driver = new MyHtmlUnitDriver(capabilities);
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

	@Given("unsere Sprache ist $sprache.")
	public void setLanguage(final String sprache) throws Throwable {
		if (sprache.equals("Deutsch")) {
			driver.changeLocaleTo(Locale.GERMAN);
		} else if (sprache.equals("Englisch")) {
			driver.changeLocaleTo(Locale.ENGLISH);
		} else {
			Assert.fail();
		}
	}

	@When("wir navigieren zur Startseite,")
	public void navigateToStartseite() throws Throwable {
		final StartSeite startseite = new StartSeite(driver);
		page = startseite.open();
		Assert.assertTrue(page.isCurrentPage());
	}

	@Then("finden wir eine Schaltfläche welche $text lautet.")
	public void findButtonWithText(final String text) throws Throwable {
		final WebElement element = driver.findElement(By.linkText(text));
		Assert.assertNotNull(element);
	}

}
