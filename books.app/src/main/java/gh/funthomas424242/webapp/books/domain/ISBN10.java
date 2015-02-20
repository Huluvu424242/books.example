package gh.funthomas424242.webapp.books.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ISBN")
public class ISBN10 extends ISBN {

	protected ISBN10(){
		
	}
	
	protected ISBN10(String[] isbnParts) {
		super("", isbnParts[0], isbnParts[1], isbnParts[2], isbnParts[3]);
	}

	public ISBN10(final String gruppenNummer, final String verlagsNummer,
			final String bandTitelNummer, final String pruefZiffer) {
		super("", gruppenNummer, verlagsNummer, bandTitelNummer, pruefZiffer);
	}

	@Override
	public boolean isValid() {

		final StringBuffer numberPart = new StringBuffer();
		// prefix geht nicht in die Berechnung ein, da erst ab ISBN13 definiert
		numberPart.append(gruppenNummer);
		numberPart.append(verlagsNummer);
		numberPart.append(bandTitelNummer);

		if (numberPart.length() != 9) {
			return false;
		} else {
			final String berechnetePruefziffer = berechnePruefziffer(numberPart);
			return this.pruefZiffer.equals(berechnetePruefziffer);
		}
	}

	@Override
	protected String berechnePruefziffer(final StringBuffer numberPart) {

		int summe = 0;
		for (int i = 10; i > 1; i--) {
			final char c = numberPart.charAt(10 - i);
			final String digit = Character.toString(c);
			int value = Integer.parseInt(digit);
			summe = summe + (value * i);
		}
		int pruefDigit = (11 - (summe % 11)) % 11;
		return Integer.toString(pruefDigit);
	}

}
