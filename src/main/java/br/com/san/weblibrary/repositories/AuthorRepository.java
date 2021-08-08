package br.com.san.weblibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.san.weblibrary.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
