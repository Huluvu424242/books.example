package gh.funthomas424242.webapp.books.tests.infrastructure;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.domain.InvalidISBNException;
import gh.funthomas424242.webapp.books.infrastructure.ISBNRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
@DirtiesContext
@Transactional
public class ISBNRepositoryTest {

	@Autowired
	ISBNRepository isbnRepository;

	@Before
	public void clearEntries() {
		isbnRepository.deleteAll();
	}

	@Test
	public void emptyRepository() {
		assertEquals(0, isbnRepository.findAll().size());
	}

	@Test
	public void addOneISBN() throws InvalidISBNException {

		isbnRepository.save(ISBN.parseFromString("3-7-33-5-3"));
		assertEquals(1, isbnRepository.findAll().size());

	}

	@Test
	public void addTwoISBN() throws InvalidISBNException {

		isbnRepository.save(ISBN.parseFromString("3-7-33-5-3"));
		isbnRepository.save(ISBN.parseFromString("3-7-33-5-3"));
		assertEquals(2, isbnRepository.findAll().size());

	}

}
