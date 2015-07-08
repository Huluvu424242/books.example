package gh.funthomas424242.webapp.books.tests.infrastructure;

import static org.junit.Assert.assertEquals;
import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.domain.InvalidISBNException;
import gh.funthomas424242.webapp.books.infrastructure.BookRepository;
import gh.funthomas424242.webapp.books.infrastructure.ISBNRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
@DirtiesContext
@Transactional
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
	public void addTwoEqualBooksWithISBNDuplicate() throws InvalidISBNException {
		final ISBN isbn = ISBN.parseFromString("3-7-33-5-3");
		isbnRepository.save(isbn);
		final Book book = new Book("Test", isbn);
		bookRepository.save(book);
		final ISBN isbn1 =ISBN.parseFromString("3-7-33-5-3");
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
	public void addTwoDifferentBooksWithDifferentISBN() throws InvalidISBNException {
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
	public void LoescheAlleBuecherErhalteEinLeeresBuecherregal() throws InvalidISBNException {
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
