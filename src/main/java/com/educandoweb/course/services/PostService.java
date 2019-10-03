package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.domain.Post;
import com.educandoweb.course.repository.PostRepository;
import com.educandoweb.course.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	// Declarando o metado findAll retornado todos os obj do BD
	@Autowired
	private PostRepository repo;

	// Declarando o metado findById caso os obj não seja encontrado no BD
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}
	
	public List<Post> findByTitle(String text) {
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
