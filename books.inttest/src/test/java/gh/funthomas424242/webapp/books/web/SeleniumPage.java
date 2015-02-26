package gh.funthomas424242.webapp.books.web;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public abstract class SeleniumPage {
//
//	protected WebDriver driver;
//
//	abstract public String getPageUrl();
//
//	public SeleniumPage(final WebDriver driver) {
//		this.driver = driver;
//	}
//
//	public SeleniumPage open() {
//		driver.get(getPageUrl());
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		return this;
//	}
//
//	public boolean isCurrentPage() {
//		final String url = driver.getCurrentUrl();
//		return getPageUrl().equals(url);
//	}
//
//	public void pressLink(String text) {
//		driver.findElement(By.linkText(text)).click();
//	}
//
//	public String findUeberschrift(final String id) {
//		return driver.findElement(By.id(id)).getText();
//	}
//
//	// public void found(final String text) {
//	// found(getPageSource(), text);
//	// }
//	//
//	// public void found(final String pageSource, final String text) {
//	// if (!pageSource.contains(escapeHtml(text))) {
//	// fail("Text: '" + text + "' not found in page '" + pageSource + "'");
//	// }
//	// }
//	//
//	// public void found(final List<String> texts) {
//	// for (final String text : texts) {
//	// found(text);
//	// }
//	// }
//	//
//	// public void notFound(final String text) {
//	// notFound(getPageSource(), text);
//	// }
//	//
//	// public void notFound(final String pageSource, final String text) {
//	// assertThat(pageSource.contains(escapeHtml(text)), is(false));
//	// }
//	//
//	// private String escapeHtml(final String text) {
//	// return text.replace("<", "&lt;").replace(">", "&gt;");
//	// }
//
//}