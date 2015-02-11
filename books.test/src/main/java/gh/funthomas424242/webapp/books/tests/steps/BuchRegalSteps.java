package gh.funthomas424242.webapp.books.tests.steps;

import java.util.List;

import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.infrastructure.BookRepository;

import org.jbehave.core.annotations.AsParameters;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Parameter;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

@Steps
public class BuchRegalSteps {

	@AsParameters
	public static class BookRow {

		@Parameter(name = "BOOK")
		private String buchTitel;

		@Parameter(name = "ISBN")
		private String isbn;

		public String getBuchTitel() {
			return buchTitel;
		}

		public void setBuchTitel(String bookTitel) {
			this.buchTitel = bookTitel;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
	}

    @Autowired
    private BookRepository bookRepository;

    @Given("Ein leeres Bücherregal.")
    public void emptyShoppingCart() {
        bookRepository.deleteAll();
    }

    @When("Bücher werden hinzugefügt zum Bücherregal: $rows")
    public void addProducts(List<BookRow> rows) {
        for (BookRow row : rows) {
            final List<Book> books = bookRepository.findByTitel(row.getBuchTitel());
            //shoppingCartService.addProductToShoppingCart(product.getSku(), row.getQuantity());
        }
    }

    @Then("Das Buchregal ist leer.")
    public void isEmpty() {
//        BookRow shoppingCart = shoppingCartService.getShoppingCart();
//        assertEquals(0, shoppingCart.numberOfItems());
    }

    @Then("Die Anzahl der Bücher im Bücherregal ist $numberOfItems")
    public void numberOfItems(int numberOfItems) {
//        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart();
//        assertEquals(numberOfItems, shoppingCart.numberOfItems());
    }

    @Then("total price is $price")
    @Pending
    public void totalPrice(ISBN isbn) {
        // TODO: implement missing functionality and enable step
    }
}

