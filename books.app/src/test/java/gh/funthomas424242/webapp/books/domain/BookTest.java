package gh.funthomas424242.webapp.books.domain;

import org.junit.Assert;
import org.junit.Test;

public class BookTest {

	@Test
	public void checkCreateAnBookWithInvalidISBN() {
		final String titel = "Die Päpstin";
		Book buch;
		try {
			final ISBN isbn = ISBN.parseFromString("3-77-77-88-7777");
			buch = new Book(titel, isbn);
			Assert.assertNotNull(buch);
		} catch (InvalidISBNException ex) {
			Assert.fail();
		}
		
	}

}
