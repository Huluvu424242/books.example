package gh.funthomas424242.webapp.books.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * International Standard Book Number. Es gibt zwei Formate: ISBN-10 (alt) und
 * ISBN-13 (neu). Zur Konvertierung von ISBN-10 in ISBN-13 wird der Prefix 978
 * vorangestellt und die Prüfsumme mit dem ISBN-13 Algorithmus neu berechnet.
 * 
 * @author huluvu424242
 * 
 */
@Entity
public class ISBN {


	@Id
	@GeneratedValue
	protected long id;

	// ISBN Ziffernfolge
	protected String isbnDigits;
	// user formatierte und getrimmte Wert
	protected String formattedValue;

	// optionale Angaben evtl. aus formatierten Wert abgeleitet
	protected String prefix;
	protected String gruppenNummer;
	protected String verlagsNummer;
	protected String bandTitelNummer;
	protected String pruefZiffer;

	protected ISBN() {

	}

	protected ISBN(final String isbnDigits, final String formattedValue) {
		this.isbnDigits = isbnDigits;
		this.formattedValue = formattedValue.trim();
		final String[] isbnParts = parseIntoParts(formattedValue);
		// 1. Segment von rechts
		if (isbnParts.length > 0) {
			this.pruefZiffer = isbnParts[isbnParts.length - 1];
		}else{
			this.pruefZiffer="";
		}
		// 2. Segment von rechts
		if (isbnParts.length > 1) {
			this.bandTitelNummer = isbnParts[isbnParts.length - 2];
		}else{
			this.bandTitelNummer="";
		}
		// 3. Segment von rechts
		if (isbnParts.length > 2) {
			this.verlagsNummer = isbnParts[isbnParts.length - 3];
		}else{
			this.verlagsNummer="";
		}
		// 4. Segment von rechts
		if (isbnParts.length > 3) {
			this.gruppenNummer = isbnParts[isbnParts.length - 4];
		}else{
			this.gruppenNummer="";
		}
		// 5. Segment von rechts
		if (isbnParts.length > 4) {
			this.prefix = isbnParts[isbnParts.length - 5];
		}else{
			this.prefix="";
		}

	}

	protected int getDigitBase(){
		return 13;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((isbnDigits == null) ? 0 : isbnDigits.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ISBN)) {
			return false;
		}
		ISBN other = (ISBN) obj;
		if (isbnDigits == null) {
			if (other.isbnDigits != null) {
				return false;
			}
		} else if (!isbnDigits.equals(other.isbnDigits)) {
			return false;
		}
		return true;
	}
	
	
	
	
	@Override
	public String toString() {
		final StringBuffer buf = new StringBuffer();
		if (prefix.length() > 0) {
			buf.append(prefix);
			buf.append("-");
		}

		if (gruppenNummer.length() > 0) {
			buf.append(gruppenNummer);
			buf.append("-");
		}

		if (verlagsNummer.length() > 0) {
			buf.append(verlagsNummer);
			buf.append("-");
		}

		if (bandTitelNummer.length() > 0) {
			buf.append(bandTitelNummer);
			buf.append("-");
		}

		if (pruefZiffer.length() > 0) {
			buf.append(pruefZiffer);
		}
		return buf.toString();
	}

	public static ISBN parseFromString(final String isbnraw)
			throws InvalidISBNException {
		final String isbnNumbers = extractNumbers(isbnraw);
		ISBN isbn = null;
		if (isbnNumbers.length() <= 10) {
			isbn = new ISBN10(isbnNumbers,isbnraw);
		}
		if (isbnNumbers.length() >= 13) {
			isbn = new ISBN(isbnNumbers,isbnraw);
		}
		return isbn;
	}

	protected static String[] parseIntoParts(String isbnraw) {
		final String[] parts = isbnraw.split("-");
		return parts;
	}

	protected static String extractNumbers(final String untrimmedISBN)
			throws InvalidISBNException {
		if (untrimmedISBN == null) {
			throw new InvalidISBNException(untrimmedISBN);
		}
		final String trimmedISBN = untrimmedISBN.trim();
		final StringBuffer buf = new StringBuffer();
		for (int index = 0; index < trimmedISBN.length(); index++) {
			final char ch = trimmedISBN.charAt(index);
			if (Character.isDigit(ch)) {
				buf.append(ch);
			}
		}
		return buf.toString();
	}

	public boolean isValid() {
		
		if(isbnDigits == null || isbnDigits.length() <1){
			return false;
		}

		final String contentPart = isbnDigits.substring(0,
				isbnDigits.length() - 1);

		if (contentPart.length() != (getDigitBase()-1)) {
			return false;
		} else {
			final char pruefZifferSoll = isbnDigits
					.charAt(isbnDigits.length() - 1);
			final String berechnetePruefziffer = berechnePruefziffer(contentPart);
			return String.valueOf(pruefZifferSoll)
					.equals(berechnetePruefziffer);
		}
	}

	protected String berechnePruefziffer(final String numberPart) {

		int summe = 0;
		for (int i = 0; i < 11; i = i + 2) {
			/* berechne *1 */{
				final char c = numberPart.charAt(i);
				final String digit = Character.toString(c);
				int value = Integer.parseInt(digit);
				summe = summe + value;
			}
			/* berechne *3 */{
				final char c = numberPart.charAt(i + 1);
				final String digit = Character.toString(c);
				int value = Integer.parseInt(digit);
				summe = summe + (value * 3);
			}
		}
		int remainderMod10 = summe % 10;
		int pruefDigit = 10 - remainderMod10;
		return Integer.toString(pruefDigit);
	}

	public String getPrefix() {
		return prefix;
	}

	public String getGruppenNummer() {
		return gruppenNummer;
	}

	public String getVerlagsNummer() {
		return verlagsNummer;
	}

	public String getBandTitelNummer() {
		return bandTitelNummer;
	}

	public String getPruefZiffer() {
		return pruefZiffer;
	}

}
