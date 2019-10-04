package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.domain.User;
import com.educandoweb.course.dto.UserDTO;
import com.educandoweb.course.repository.UserRepository;
import com.educandoweb.course.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	// Instaciando o obj UserRepository
	@Autowired
	private UserRepository repo;

	// findAll responsavel retorna todos os usuários no BD
	public List<User> findAll() {
		return repo.findAll();

	}

	// Declarando o metado findById caso os obj não seja encontrado no BD reternando null, lançando exceção
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	// Declarando metado para inserir no BD
	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	// Metado User para atualizar o BD
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());

	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());

	}
}
