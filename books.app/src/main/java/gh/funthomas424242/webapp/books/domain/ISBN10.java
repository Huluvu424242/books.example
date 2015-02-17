package gh.funthomas424242.webapp.books.domain;

public class ISBN10 extends ISBN {

	protected ISBN10(String[] isbnParts) {
		super("978", isbnParts[0], isbnParts[1], isbnParts[2], isbnParts[3]);
	}

	public ISBN10(final String gruppenNummer, final String verlagsNummer,
			final String bandTitelNummer, final String pruefZiffer) {
		super("978", gruppenNummer, verlagsNummer, bandTitelNummer, pruefZiffer);
	}

}
