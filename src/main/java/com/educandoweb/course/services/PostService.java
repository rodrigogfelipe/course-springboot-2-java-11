package com.educandoweb.course.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.domain.Post;
import com.educandoweb.course.repository.PostRepository;
import com.educandoweb.course.services.exception.ObjectNotFoundException;
/*Em PostService, criar o método de busca */
@Service
public class PostService {
	// Declarando o metado findAll retornado todos os obj do BD
	@Autowired
	private PostRepository repo;

	// Em PostService, criar o método de consulta . Declarando o metado findById caso os obj não seja encontrado no BD
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}

	public List<Post> fullSearch(String text, java.util.Date min, java.util.Date max) {
		max = new Date(max.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, min, max);
	}
}
