package gh.funthomas424242.webapp.books.tests.steps;

import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.infrastructure.BookRepository;

import org.jbehave.core.annotations.Given;
import org.springframework.beans.factory.annotation.Autowired;

@Steps
public class SharedSteps {

    @Autowired
    private BookRepository bookRepository;

   
    @Given("book $titel with ISBN $isbn")
    public void product(String titel, String isbn) {
       // bookRepository.save(new Book(titel, isbn));
    }

//    @Given("book $titel isbn is $isbn")
//    public void price(String titel, String isbn) {
//        Book book = bookRepository.findByTitel(titel);
//        bookRepository.save(book.getIsbn(), isbn);
//    }
}
