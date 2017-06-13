package it.uniroma3.spring.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Author;
import it.uniroma3.spring.model.Picture;

public interface PictureRepository extends CrudRepository<Picture, Long> {
	List<Picture> findByTechnique(String technique);
	List<Picture> findByAuthor(Author author);
	List<Picture> findAll();
	List<Author> findByTitle(String title);
}

