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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import gh.funthomas424242.webapp.books.web.WebResource;

@Entity
public class Book extends WebResource{

	@Id
	@GeneratedValue
	protected long id;

	protected String titel;

	@ManyToOne
	protected ISBN isbn;

	public Book() {

	}

	public Book(final String titel, final ISBN isbn) {
		this.titel = titel;
		this.isbn = isbn;
	}

	public long getId() {
		return id;
	}

	public String getTitel() {
		return titel;
	}

	
	public ISBN getIsbn() {
		return isbn;
	}

	@Override
	public String getResourcePathPattern() {
		return "{baseURL}/book/{id}";
	}

}
