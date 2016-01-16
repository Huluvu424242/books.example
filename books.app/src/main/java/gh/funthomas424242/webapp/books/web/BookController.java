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
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.domain.InvalidISBNException;
import gh.funthomas424242.webapp.books.service.BookService;
import gh.funthomas424242.webapp.books.service.ISBNService;

@Controller
public class BookController {

    final Logger LOG = LoggerFactory.getLogger(BookController.class);

    protected final BookService bookService;

    protected final ISBNService isbnService;

    @Inject
    public BookController(final BookService bookService,
            final ISBNService isbnService) {
        LOG.trace("BookController(" + bookService + ", " + isbnService + ")");
        this.bookService = bookService;
        this.isbnService = isbnService;
    }

    protected List<Book> retrieveAllBooks() {
        return this.bookService.findAll();
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Resources<Book>> listeBuecher() {
        LOG.trace("listeBuecher()");
        final List<Book> books = retrieveAllBooks();
        // for(final Book book:books){
        // book.add(linkTo(methodOn(BookController.class).getBuch(book.getId()))
        // .withSelfRel());
        // }
        final Resources<Book> buchregal = new Resources<Book>(books);
        buchregal.add(linkTo(methodOn(BookController.class).listeBuecher())
                .withSelfRel());
        LOG.trace("Books:" + books);
        return new ResponseEntity<Resources<Book>>(buchregal, HttpStatus.OK);
    }

    // @ApiMethod
    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public void loescheBuch(@PathVariable Long id) {
        LOG.trace("loescheBuch(" + id + ")");
        this.bookService.deleteBook(id);
    }

    @RequestMapping(value = "/book/new", method = RequestMethod.POST)
    public void speichereBuch(@RequestParam(required = true) final String titel,
            @RequestParam(required = true, defaultValue = "") final String isbnraw)
                    throws InvalidISBNException {
        LOG.trace("speichereBuch(" + titel + ", " + isbnraw + ")");
        ISBN isbn = null;

        if (isbnraw.length() > 0) {
            isbn = ISBN.parseFromString(isbnraw);
            this.isbnService.addISBN(isbn);
        }
        this.bookService.addBook(titel, isbn);
    }

}
