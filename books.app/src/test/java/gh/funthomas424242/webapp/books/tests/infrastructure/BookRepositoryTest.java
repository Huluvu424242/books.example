package gh.funthomas424242.webapp.books.tests.infrastructure;

import static org.junit.Assert.assertEquals;
import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.infrastructure.BookRepository;
import gh.funthomas424242.webapp.books.web.BookController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository; 
	
	@Test
	public void createAndQuery() {
		assertEquals(0, bookRepository.findByTitel("Ede und Unku").size());
		bookRepository.save(new Book("Die Mutter", "3-7-33-5"));
		assertEquals(1, bookRepository.findByIsbn("3-7-33-5").size());
	}

}

