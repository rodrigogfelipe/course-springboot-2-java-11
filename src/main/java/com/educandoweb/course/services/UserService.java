package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.domain.User;
import com.educandoweb.course.repository.UserRepository;
import com.educandoweb.course.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	// Declarando o metado findAll retornado todos os obj do BD
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();

	}

	// Declarando o metado findById caso os obj não seja encontrado no BD
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
