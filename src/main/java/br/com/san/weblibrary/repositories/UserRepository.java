package br.com.san.weblibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.san.weblibrary.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
