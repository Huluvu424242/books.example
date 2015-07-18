package gh.funthomas424242.webapp.books.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book implements Serializable{

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

}
