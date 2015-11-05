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

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.domain.InvalidISBNException;
import gh.funthomas424242.webapp.books.service.BookService;
import gh.funthomas424242.webapp.books.service.ISBNService;

@Path("/")
@Provider
public class BookController {

	protected final BookService bookService;

	protected final ISBNService isbnService;

	@Inject
	public BookController(final BookService bookService, final ISBNService isbnService) {
		this.bookService = bookService;
		this.isbnService = isbnService;
	}

	protected List<Book> retrieveAllBooks() {
		return this.bookService.findAll();
	}

	@GET
	@Path("/books")
	public WebState listeBuecher(@Context final HttpServletRequest request) {
		final String selfURL = request.getRequestURL().toString();
		final String baseURL = selfURL.substring(0, selfURL.length() - request.getRequestURI().length())
				+ request.getContextPath() + "/";
		// convert book list to resource array
		final List<Book> books = retrieveAllBooks();
		final WebResource[] resources = new WebResource[books.size()];
		books.toArray(resources);
		final WebState webState = new WebState(baseURL, selfURL, resources);
		webState.setNewURL(baseURL + "book/new");
		return webState;
	}

	// @ApiMethod
	@DELETE
	@Path("/book/{id}")
	public void loescheBuch(@PathParam("id") Long id) {
		System.out.println("loeschen aufgerufen");
		System.out.println("ID:" + id);
		this.bookService.deleteBook(id);
	}

	@POST
	@Path("/book/new")
	public void speichereBuch(@Context final HttpServletRequest request,
			@NotNull @QueryParam("titel") final String titel,
			@DefaultValue("") @QueryParam("isbn") final String isbnraw) throws InvalidISBNException {

		System.out.println("Titel: " + titel);
		System.out.println("ISB: " + isbnraw);

		ISBN isbn = null;

		if (isbnraw.length() > 0) {
			isbn = ISBN.parseFromString(isbnraw);
			this.isbnService.addISBN(isbn);
		}
		this.bookService.addBook(titel, isbn);
	}

}
