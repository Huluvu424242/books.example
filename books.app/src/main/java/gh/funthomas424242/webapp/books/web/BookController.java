package gh.funthomas424242.webapp.books.web;

import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.service.BookService;
import gh.funthomas424242.webapp.books.service.ISBNService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BookController {

	private final BookService bookService;

	private final ISBNService isbnService;

	@Autowired
	public BookController(final BookService bookService,
			final ISBNService isbnService) {
		this.bookService = bookService;
		this.isbnService = isbnService;
	}

	@ModelAttribute("allBooks")
	public List<Book> populateFeatures() {
		return this.bookService.findAll();
	}
	
	@RequestMapping({ "/", "${link.books}" })
	public ModelAndView listeBuecher() {
		return new ModelAndView("booklist","books", bookService.findAll());
	}


	@RequestMapping("${link.buch.erfassen}")
	public ModelAndView erfasseBuch() {
		return new ModelAndView("erfassebuch");
	}

	@RequestMapping("${link.buch.registrieren}")
	public ModelAndView speichereBuch(HttpServletRequest request,
			@RequestParam("titel") final String titel,
			@RequestParam("isbn") final String isbnraw) {

		final ISBN isbn = ISBN.parseFromString(isbnraw);
		isbnService.addISBN(isbn);
		bookService.addBook(titel, isbn);
		return new ModelAndView("booklist", "books", bookService.findAll());
	}

}
