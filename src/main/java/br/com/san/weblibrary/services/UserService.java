package br.com.san.weblibrary.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.san.weblibrary.entities.User;
import br.com.san.weblibrary.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> optional = repository.findById(id);
		return optional.get();
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public User update(User user, Long id) {
		User entity = repository.getById(id);
		updateDataUser(entity, user);
		return repository.save(entity);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	private void updateDataUser(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
}
