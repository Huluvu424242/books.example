package gh.funthomas424242.webapp.books.domain;

import org.junit.Assert;
import org.junit.Test;

public class ISBNTest {

	@Test
	public void checkAValidISBN13asValid() {
		final String rawisbn = "978-0-306-40615-7";
		ISBN isbn;
		try {
			isbn = ISBN.parseFromString(rawisbn);
			Assert.assertTrue(isbn.isValid());
		} catch (InvalidISBNException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void checkAValidISBN10asValid() {
		final String rawisbn = "0-306-40615-2";
		ISBN isbn;
		try {
			isbn = ISBN.parseFromString(rawisbn);
			Assert.assertTrue(isbn.isValid());
		} catch (InvalidISBNException e) {
			Assert.fail();
		}
	}

}
