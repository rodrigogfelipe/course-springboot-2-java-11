package com.educandoweb.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.domain.User;
import com.educandoweb.course.repository.UserRepository;

@Service
public class UserService {
	// Declarando o metado findAll retornado todos os obj do BD
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();

	}

}
