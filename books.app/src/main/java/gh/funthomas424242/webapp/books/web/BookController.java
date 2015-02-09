package gh.funthomas424242.webapp.books.web;

import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.service.BookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BookController {

	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	// public BookController(BookRepository bookRepository) {
	// this.bookRepository = bookRepository;
	// bookRepository.save(new Book("Ede und Unku","1-3-335-3"));
	// bookRepository.save(new Book("Nackt unter Wölfen","1-3-333-3"));
	// }

	@ModelAttribute("allBooks")
	public List<Book> populateFeatures() {
		return this.bookService.findAll();
	}

	@RequestMapping({ "/", "/books" })
	public ModelAndView listeBuecher() {
		return new ModelAndView("booklist", "books", bookService.findAll());
	}

	@RequestMapping("/book/add")
	public ModelAndView erfasseBuch() {
		return new ModelAndView("addbook", "book", new Book());
	}

	@RequestMapping("/book/save")
	public ModelAndView speichereBuch(@RequestParam("titel") final String titel,@RequestParam("isbn") final String isbn) {
		bookService.addBook(titel, isbn);
		return new ModelAndView("booklist", "books", bookService.findAll());
	}

}
