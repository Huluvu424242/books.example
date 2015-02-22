package gh.funthomas424242.webapp.books.tests;

import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.service.BookService;
import gh.funthomas424242.webapp.books.service.ISBNService;

import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import cucumber.api.java.de.Dann;
import cucumber.api.java.de.Gegebensei;
import cucumber.api.java.de.Wenn;

@SpringApplicationConfiguration(classes = { Application.class })
public class BuchTestSchritte {

	@Autowired
	protected BookService bookService;

	@Autowired
	protected ISBNService isbnService;
	
	
	@Gegebensei("^ein leeres Bücherregal\\.$")
	public void GegebenLeeresBuecherregal() throws Throwable {
		bookService.deleteAll();
		final List<Book> alleBuecher = bookService.findAll();
		Assert.assertTrue(alleBuecher.isEmpty());
	}

	@Wenn("^ich ein Buch mit dem Titel \"(.*?)\" ohne ISBN hinzufüge\\.$")
	public void buchHinzufuegen(final String titel) throws Throwable {
		bookService.addBook(titel, null);
	}

	@Dann("^enthält das Bücherregal (\\d+) Bücher\\.$")
	public void buchHinzufuegen(final int anzahlBuecher) {
		final List<Book> alleBuecher = bookService.findAll();
		Assert.assertEquals(1, alleBuecher.size());
	}

	@Wenn("^ich ein Buch mit dem Titel \"(.*?)\" und der ISBN \"(.*?)\" hinzufüge\\.$")
	public void ich_ein_Buch_mit_dem_Titel_und_der_ISBN_hinzufüge(
			final String titel, final String isbn) throws Throwable {
		final ISBN isbnEntity = ISBN.parseFromString(isbn);
		isbnService.addISBN(isbnEntity);
		bookService.addBook(titel, isbnEntity);
	}

	@Dann("^enthält das Bücherregal 1 Buch mit gültiger ISBN\\.$")
	public void buchHinzufuegen() {
		final List<Book> alleBuecher = bookService.findAll();
		Assert.assertEquals(1, alleBuecher.size());
		final Book buch = alleBuecher.get(0);
		Assert.assertTrue(buch.getIsbn().isValid());
	}
}
