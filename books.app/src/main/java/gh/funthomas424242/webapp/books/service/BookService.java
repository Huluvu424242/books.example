package gh.funthomas424242.webapp.books.service;

import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.infrastructure.BookRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {


	private final BookRepository bookRepository;

	@Autowired
	public BookService(final BookRepository bookRepository){
		this.bookRepository=bookRepository;
	}

	public List<Book> findAll() {
		return this.bookRepository.findAll();
	}

	public void addBook(final String titel, final String isbn) {
		final Book book = new Book(titel,isbn);
		this.bookRepository.saveAndFlush(book);
	}

}
