package gh.funthomas424242.webapp.books.web;

/*
 * #%L
 * Books.App
 * %%
 * Copyright (C) 2015 Pivotal Software, Inc.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.lib.MyHtmlUnitDriver;
import gh.funthomas424242.webapp.books.lib.Steps;
import gh.funthomas424242.webapp.books.web.pages.SeleniumPage;
import gh.funthomas424242.webapp.books.web.pages.StartSeite;

import java.util.List;
import java.util.Locale;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
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
		final StartSeite startseite =PageFactory.initElements(driver, StartSeite.class);
		page = startseite.open(driver);
		Assert.assertEquals(page.getPageUrl(),driver.getCurrentUrl());
	}

	@Then("finden wir eine Schaltfläche welche $text lautet.")
	public void findButtonWithText(final String text) throws Throwable {
		final WebElement element = driver.findElement(By.linkText(text));
		Assert.assertNotNull(element);
	}
	
	@Then("eine Überschrift $ueberschrift.")
	public void containsUeberschrift(final String ueberschrift){
		final StartSeite startseite=(StartSeite)page;
		Assert.assertEquals(ueberschrift, startseite.getUeberschrift());
	}
	
	@Then("eine Tabelle mit den Spalten: $spaltenNamen.")
	public void containsTabellenspalten(final List<String> spaltenNamen){
		final StartSeite startseite=(StartSeite)page;
		Assert.assertEquals(spaltenNamen, startseite.getSpaltennamenDerTabelle());
	}

}
