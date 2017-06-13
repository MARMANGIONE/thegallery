package it.uniroma3.spring.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.spring.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
	List<Author> findByName(String name);
	List<Author> findBySurname(String surname);
	List<Author> findByNationality(String nationality);
	List<Author> findAll();
}
