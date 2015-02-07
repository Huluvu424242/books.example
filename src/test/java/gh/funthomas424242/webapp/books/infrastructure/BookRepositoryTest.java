package gh.funthomas424242.webapp.books.infrastructure;

import static org.junit.Assert.assertEquals;
import gh.funthomas424242.webapp.books.BookController;
import gh.funthomas424242.webapp.books.domain.Book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BookController.class)
@Transactional
public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository; 
	
	@Test
	public void findByTitel() {
		bookRepository.save(new Book("Käutzchenkuhle","1-3-335-4"));
		assertEquals(1, bookRepository.findByTitel("Käutzchenkuhle").size());
	}

	@Test
	public void findByIsbn() {
		bookRepository.save(new Book("Die Mutter","1-3-335-8"));
		assertEquals(1, bookRepository.findByIsbn("1-3-335-8").size());
	}
	
}
