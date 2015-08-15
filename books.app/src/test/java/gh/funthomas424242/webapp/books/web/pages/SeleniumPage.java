package gh.funthomas424242.webapp.books.web.pages;

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