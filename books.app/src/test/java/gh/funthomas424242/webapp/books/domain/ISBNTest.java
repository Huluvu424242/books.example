package gh.funthomas424242.webapp.books.domain;

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
