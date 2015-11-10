package gh.funthomas424242.webapp.books.services;

/*
 * #%L
 * Books.App - Cucumber Tests
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
import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.service.BookService;
import gh.funthomas424242.webapp.books.service.ISBNService;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.springframework.boot.test.SpringApplicationConfiguration;

import cucumber.api.java.de.Dann;
import cucumber.api.java.de.Gegebensei;
import cucumber.api.java.de.Wenn;

@SpringApplicationConfiguration(classes = { Application.class })
public class BuchTestSchritte {

	@Inject
	protected BookService bookService;

	@Inject
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
	public void buchHinzufuegenValidISBN() {
		final List<Book> alleBuecher = bookService.findAll();
		Assert.assertEquals(1, alleBuecher.size());
		final Book buch = alleBuecher.get(0);
		Assert.assertTrue(buch.getIsbn().isValid());
	}
	
	@Dann("^enthält das Bücherregal 1 Buch mit ungültiger ISBN\\.$")
	public void buchHinzufuegenInvalidISBN() {
		final List<Book> alleBuecher = bookService.findAll();
		Assert.assertEquals(1, alleBuecher.size());
		final Book buch = alleBuecher.get(0);
		Assert.assertFalse(buch.getIsbn().isValid());
	}
}
