package gh.funthomas424242.webapp.books.infrastructure;

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

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.domain.InvalidISBNException;
import gh.funthomas424242.webapp.books.infrastructure.BookRepository;
import gh.funthomas424242.webapp.books.infrastructure.ISBNRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
@DirtiesContext
@Transactional
// TODO DB Anbindung fehlt
@Ignore
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ISBNRepository isbnRepository;

    @Before
    public void prepareTests() {
        bookRepository.deleteAll();
    }

    @Test
    public void emptyRepository() {
        assertEquals(0, bookRepository.findAll().size());
    }

    @Test
    public void addBookWithoutISBN() {
        final Book book = new Book("Test", null);
        bookRepository.save(book);
        assertEquals(1, bookRepository.findAll().size());
    }

    @Test
    public void addBookWithISBN() throws InvalidISBNException {
        final ISBN isbn = ISBN.parseFromString("3-7-33-5-3");
        isbnRepository.save(isbn);
        final Book book = new Book("Test", isbn);
        bookRepository.save(book);
        assertEquals(1, bookRepository.findAll().size());
    }

    @Test
    public void addBookWithInvalidISBN() throws InvalidISBNException {
        final String titel = "Die Päpstin";
        try {
            final ISBN isbn = ISBN.parseFromString("3-77-77-88-7777");
            isbnRepository.save(isbn);
            final Book book = new Book(titel, isbn);
            bookRepository.save(book);
            assertEquals(1, bookRepository.findAll().size());
        } catch (InvalidISBNException ex) {
            Assert.fail();
        }

    }

    @Test
    public void addTwoEqualBooksWithISBNDuplicate()
            throws InvalidISBNException {
        final ISBN isbn = ISBN.parseFromString("3-7-33-5-3");
        isbnRepository.save(isbn);
        final Book book = new Book("Test", isbn);
        bookRepository.save(book);
        final ISBN isbn1 = ISBN.parseFromString("3-7-33-5-3");
        isbnRepository.save(isbn1);
        final Book book1 = new Book("Test", isbn1);
        bookRepository.save(book1);
        assertEquals(2, bookRepository.findAll().size());
    }

    @Test
    public void addTwoEqualBooksWithSameISBN() throws InvalidISBNException {
        final ISBN isbn = ISBN.parseFromString("3-7-33-5-3");
        isbnRepository.save(isbn);
        final Book book = new Book("Test", isbn);
        bookRepository.save(book);
        final Book book1 = new Book("Test", isbn);
        bookRepository.save(book1);
        assertEquals(2, bookRepository.findAll().size());
    }

    @Test
    public void addTwoDifferentBooksWithSameISBN() throws InvalidISBNException {
        final ISBN isbn = ISBN.parseFromString("3-7-33-5-3");
        isbnRepository.save(isbn);
        final Book book = new Book("Test", isbn);
        bookRepository.save(book);
        final Book book1 = new Book("Test und Testing", isbn);
        bookRepository.save(book1);
        assertEquals(2, bookRepository.findAll().size());
    }

    @Test
    public void addTwoDifferentBooksWithDifferentISBN()
            throws InvalidISBNException {
        final ISBN isbn = ISBN.parseFromString("3-7-33-5-3");
        isbnRepository.save(isbn);
        final Book book = new Book("Test", isbn);
        bookRepository.save(book);
        final ISBN isbn1 = ISBN.parseFromString("3-7-33-5-4");
        isbnRepository.save(isbn1);
        final Book book1 = new Book("Test und Testing", isbn1);
        bookRepository.save(book1);
        assertEquals(2, bookRepository.findAll().size());
    }

    @Test
    public void LoescheAlleBuecherErhalteEinLeeresBuecherregal()
            throws InvalidISBNException {
        final ISBN isbn = ISBN.parseFromString("3-7-33-5-3");
        isbnRepository.save(isbn);
        final Book book = new Book("Test", isbn);
        bookRepository.save(book);
        final ISBN isbn1 = ISBN.parseFromString("3-7-33-5-4");
        isbnRepository.save(isbn1);
        final Book book1 = new Book("Test und Testing", isbn1);
        bookRepository.save(book1);
        assertEquals(2, bookRepository.findAll().size());
        bookRepository.deleteAll();
        assertEquals(0, bookRepository.findAll().size());
    }

}
