package gh.funthomas424242.webapp.books.web.pages;

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

import org.openqa.selenium.WebDriver;

public abstract class SeleniumPage {

	abstract public String getPageUrl();

	
	public SeleniumPage open(final WebDriver driver) {
		final String pageUrl = getPageUrl();
		driver.get(pageUrl);
		return this;
	}

	// public void pressLink(String text) {
	// driver.findElement(By.linkText(text)).click();
	// }
	//
	// public String findUeberschrift(final String id) {
	// return driver.findElement(By.id(id)).getText();
	// }

	// public void found(final String text) {
	// found(getPageSource(), text);
	// }
	//
	// public void found(final String pageSource, final String text) {
	// if (!pageSource.contains(escapeHtml(text))) {
	// fail("Text: '" + text + "' not found in page '" + pageSource + "'");
	// }
	// }
	//
	// public void found(final List<String> texts) {
	// for (final String text : texts) {
	// found(text);
	// }
	// }
	//
	// public void notFound(final String text) {
	// notFound(getPageSource(), text);
	// }
	//
	// public void notFound(final String pageSource, final String text) {
	// assertThat(pageSource.contains(escapeHtml(text)), is(false));
	// }
	//
	// private String escapeHtml(final String text) {
	// return text.replace("<", "&lt;").replace(">", "&gt;");
	// }

}