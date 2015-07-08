package gh.funthomas424242.webapp.books.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class EntityTCK {

	
	@Test
	public void apiISBN() throws InvalidISBNException {
		final ISBN isbn=ISBN.parseFromString("978-3-448-09588-3");
		//assertNull(isbn.getId());
		assertEquals("978",isbn.getPrefix());
		assertEquals("3",isbn.getGruppenNummer());
		assertEquals("448",isbn.getVerlagsNummer());
		assertEquals("09588",isbn.getBandTitelNummer());
		assertEquals("3",isbn.getPruefZiffer());
	}
	
	@Test
	public void apiISBN10() throws InvalidISBNException {
		final ISBN10 isbn=(ISBN10) ISBN10.parseFromString("3-492-27500-1");
		//assertNull(isbn.getId());
		assertEquals("",isbn.getPrefix());
		assertEquals("3",isbn.getGruppenNummer());
		assertEquals("492",isbn.getVerlagsNummer());
		assertEquals("27500",isbn.getBandTitelNummer());
		assertEquals("1",isbn.getPruefZiffer());
	}
		
	@Test
	public void apiBook() throws InvalidISBNException {
		final ISBN isbn=ISBN.parseFromString("3-3");
		final String titel="Hallo Welt";
		final Book book=new Book(titel,isbn);
		assertEquals(0,book.getId());
		assertEquals(titel,book.getTitel());
		assertEquals(isbn,book.getIsbn());
	}
	
	

}
