package com.educandoweb.course.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.domain.Post;

/*Buscar posts contendo um dado string no título". Em PostRepository, criar o método de busca */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	//Criar o método de consulta .  Comparando as datas entre minimas e maximas
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , "
			+ "{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }, "
			+ "{ 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }" )
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
