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
