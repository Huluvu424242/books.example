package gh.funthomas424242.webapp.books.tests.infrastructure;

import static org.junit.Assert.assertEquals;
import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.infrastructure.ISBNRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@Transactional
public class ISBNRepositoryTest {

	@Autowired
	ISBNRepository isbnRepository;

	@Before
	public void prepareTests(){
		isbnRepository.deleteAll();
	}
	
	@Test
	public void emptyRepository() {
		assertEquals(0, isbnRepository.findAll().size());
	}

	@Test
	public void addOneISBN() {
		isbnRepository.save(new ISBN("3-7-33-5-3"));
		assertEquals(1, isbnRepository.findAll().size());
	}

	@Test
	public void addTwoISBN() {
		isbnRepository.save(new ISBN("3-7-33-5-3"));
		isbnRepository.save(new ISBN("3-7-33-5-3"));
		assertEquals(2, isbnRepository.findAll().size());
	}

}
