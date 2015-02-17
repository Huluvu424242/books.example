package gh.funthomas424242.webapp.books.domain;

public class InvalidISBNException extends Exception {

	protected String isbnraw;

	public InvalidISBNException(final String isbnraw) {
		this.isbnraw = isbnraw;
	}

}
