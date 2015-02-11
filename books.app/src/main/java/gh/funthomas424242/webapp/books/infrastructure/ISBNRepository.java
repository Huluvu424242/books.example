package gh.funthomas424242.webapp.books.infrastructure;

import gh.funthomas424242.webapp.books.domain.ISBN;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISBNRepository extends JpaRepository<ISBN, Long> {


}
