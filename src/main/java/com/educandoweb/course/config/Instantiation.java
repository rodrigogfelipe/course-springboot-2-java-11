package com.educandoweb.course.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.educandoweb.course.domain.Post;
import com.educandoweb.course.domain.User;
import com.educandoweb.course.dto.AuthorDTO;
import com.educandoweb.course.dto.CommentDTO;
import com.educandoweb.course.repository.PostRepository;
import com.educandoweb.course.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	/*UserRepository faz operação no BD*/
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		// deleteAll() limpar a coleção no mongoDB
		userRepository.deleteAll();
		postRepository.deleteAll();

		// Instaciar metado para salvar no BD
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		// Declarando o obj da classe Post
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo",
				new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "bom dia", "acordei feliz", new AuthorDTO(maria));

		// Declarando o obj da classe CommentDTO
		CommentDTO c1 = new CommentDTO("boa viagem", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("aprovaite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("tenha um otimo dia", sdf.parse("23/03/2018"), new AuthorDTO(alex));

		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));

		// saveAll salvar os obj BD
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
