package gh.funthomas424242.webapp.books.service;

import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.infrastructure.ISBNRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ISBNService {


	private final ISBNRepository isbnRepository;

	@Autowired
	public ISBNService(final ISBNRepository isbnRepository){
		this.isbnRepository=isbnRepository;
	}

	public List<ISBN> findAll() {
		return this.isbnRepository.findAll();
	}

	public void addISBN(final ISBN isbn) {
		this.isbnRepository.save(isbn);
	}

}
