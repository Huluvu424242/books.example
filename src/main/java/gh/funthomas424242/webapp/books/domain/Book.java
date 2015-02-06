package gh.funthomas424242.webapp.books.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue
	protected long id;
	
	protected String titel;
	
	protected String isbn;

	public Book(){
		
	}
	
	public Book(final String titel, final String isbn){
		this.titel=titel;
		this.isbn=isbn;
	}
	
	
	public long getId() {
		return id;
	}

	public String getTitel() {
		return titel;
	}

	public String getIsbn() {
		return isbn;
	}
	
}
