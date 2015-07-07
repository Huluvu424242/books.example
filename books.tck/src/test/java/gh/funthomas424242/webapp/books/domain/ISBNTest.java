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

	@Test
	public void checkAnUntrimmedValidISBN10asValid() {
		final String rawisbn = " 0-306-40615-2 ";
		ISBN isbn;
		try {
			isbn = ISBN.parseFromString(rawisbn);
			Assert.assertTrue(isbn.isValid());
		} catch (InvalidISBNException e) {
			Assert.fail();
		}
	}

	@Test
	public void checkAnInValidISBN10asInValid() {
		final String rawisbn = "0-306-40615-1";
		ISBN isbn;
		try {
			isbn = ISBN.parseFromString(rawisbn);
			Assert.assertFalse(isbn.isValid());
		} catch (InvalidISBNException e) {
			Assert.fail();
		}
	}

	@Test
	public void checkAnInValidISBNasInValid() {
		final String rawisbn = "0-3-40615-1";
		ISBN isbn;
		try {
			isbn = ISBN.parseFromString(rawisbn);
			Assert.assertFalse(isbn.isValid());
		} catch (InvalidISBNException e) {
			Assert.fail();
		}
	}

	@Test
	public void checkAnEmptyISBNasInValid() {
		final String rawisbn = "";
		ISBN isbn;
		try {
			isbn = ISBN.parseFromString(rawisbn);
			Assert.assertFalse(isbn.isValid());
		} catch (InvalidISBNException e) {
			Assert.fail();
		}
	}

	@Test
	public void checkAnNullISBNasInValid() {
		final String rawisbn = null;
		try {
			final ISBN isbn = ISBN.parseFromString(rawisbn);
			Assert.fail();
		} catch (InvalidISBNException e) {
			Assert.assertTrue(true);
		}
	}

}
