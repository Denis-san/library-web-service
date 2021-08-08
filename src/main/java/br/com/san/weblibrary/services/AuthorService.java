package br.com.san.weblibrary.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.san.weblibrary.entities.Author;
import br.com.san.weblibrary.repositories.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository repository;

	public List<Author> findAll() {
		return repository.findAll();
	}

	public Author findById(Long id) {
		Optional<Author> optional = repository.findById(id);
		return optional.get();
	}
}
