package com.educandoweb.course.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.educandoweb.course.domain.Post;
import com.educandoweb.course.domain.User;
import com.educandoweb.course.repository.PostRepository;
import com.educandoweb.course.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		// limpa a coleção no mongoDB 
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		
		
		// Instaciar metado para salvar no BD
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//Declarando o obj da classe Post
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "bom dia", "acordei feliz", maria);
		
		//salvar os obj no BD
		userRepository.saveAll(Arrays.asList(maria,alex, bob));
		postRepository.saveAll(Arrays.asList(post1,post2));

	}

}
