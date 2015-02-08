package gh.funthomas424242.webapp.books;

import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.infrastructure.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@EnableAutoConfiguration
public class BookController {

	private BookRepository bookRepository;
	
	@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
		bookRepository.save(new Book("Ede und Unku","1-3-335-3"));
		bookRepository.save(new Book("Nackt unter Wölfen","1-3-333-3"));
	}
	
	@RequestMapping("/")
	public ModelAndView hello() {
		return new ModelAndView("booklist","books",bookRepository.findAll());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BookController.class, args);
	}

}
