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
import javax.persistence.Table;

@Entity
@Table(name = "ISBN")
public class ISBN10 extends ISBN {

	protected ISBN10() {

	}

	protected ISBN10(final String isbnDigits, final String formattedValue) {
		super(isbnDigits, formattedValue);
	}
	
	protected int getDigitBase(){
		return 10;
	}


	@Override
	protected String berechnePruefziffer(final String numberPart) {

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
