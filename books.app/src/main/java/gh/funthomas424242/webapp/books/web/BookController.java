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

import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.domain.InvalidISBNException;
import gh.funthomas424242.webapp.books.service.BookService;
import gh.funthomas424242.webapp.books.service.ISBNService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BookController {

	protected final BookService bookService;

	protected final ISBNService isbnService;

	@Autowired
	public BookController(final BookService bookService, final ISBNService isbnService) {
		this.bookService = bookService;
		this.isbnService = isbnService;
	}

	@RequestMapping({ "${link.books}" })
	public ModelAndView listeBuecher() {
		return new ModelAndView("booklist", "books", retrieveAllBooks());
	}

	protected List<Book> retrieveAllBooks() {
		return bookService.findAll();
	}

	@RequestMapping({ "${link.books}/json" })
	public List<Book> listeBuecherJSON() {
		return retrieveAllBooks();
	}

	// @ApiMethod
	@RequestMapping(value = "${link.buch.loeschen}/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void loescheBuch(@PathVariable("id") Long id) {
		System.out.println("loeschen aufgerufen");
		System.out.println("ID:" + id);
		bookService.deleteBook(id);
	}

	private class BookData {
		public String titel;
		public String isbn;

		public BookData(final String titel, final String isbn) {
			this.titel = titel;
			this.isbn = isbn;
		};

	}

	@RequestMapping(value = "${link.buch.registrieren}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void speichereBuch(final HttpServletRequest request, 
			@RequestParam("titel") final String titel,
			@RequestParam("isbn") final String isbnraw)	throws InvalidISBNException {
		
		//System.out.println("NewBookData: " + newBookData.toString());
		System.out.println("Titel: "+titel);
		System.out.println("ISB: "+isbnraw);

//		final String isbnraw = newBookData.isbn;
//		final String titel = newBookData.titel;

		ISBN isbn = null;

		if (isbnraw.length() > 0) {
			isbn = ISBN.parseFromString(isbnraw);
			isbnService.addISBN(isbn);
		}
		bookService.addBook(titel, isbn);
	}

	@RequestMapping("${link.buch.erfassen}")
	public ModelAndView erfasseBuch() {
		final Map<String, Object> modelMap = erzeugeModelMap();
		modelMap.put("message", null);
		modelMap.put("invalidISBN", false);

		return new ModelAndView("erfassebuch", modelMap);
	}

	protected Map<String, Object> erzeugeModelMap() {
		final Map<String, Object> modelMap = new HashMap<String, Object>();
		return modelMap;
	}

}
