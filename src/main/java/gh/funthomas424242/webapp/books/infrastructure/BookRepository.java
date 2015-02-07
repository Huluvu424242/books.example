package gh.funthomas424242.webapp.books.infrastructure;

import gh.funthomas424242.webapp.books.domain.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByTitel(String titel);

}
