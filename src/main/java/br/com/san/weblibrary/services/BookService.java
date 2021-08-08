package br.com.san.weblibrary.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.san.weblibrary.entities.Book;
import br.com.san.weblibrary.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	public List<Book> findAll(){
		return repository.findAll();
	}
	
	public Book findById(Long id) {
		Optional<Book> optional = repository.findById(id);
		return optional.get();
	}
}
