package gh.funthomas424242.webapp.books.service;

import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.infrastructure.BookRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	protected final BookRepository bookRepository;

	@Autowired
	public BookService(final BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> findAll() {
		return this.bookRepository.findAll();
	}

	public void addBook(final String titel, final ISBN isbn) {
		final Book book = new Book(titel, isbn);
		this.bookRepository.save(book);
	}
	
	public void deleteBook(final Long id){
		this.bookRepository.delete(id);
	}

	public void deleteAll(){
		this.bookRepository.deleteAll();
	}
	
}
