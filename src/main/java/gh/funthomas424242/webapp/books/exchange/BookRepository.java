package gh.funthomas424242.webapp.books.exchange;

import gh.funthomas424242.webapp.books.domain.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByTitel(String titel);

}
