package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Author;
import it.uniroma3.spring.repository.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository; 

    public Iterable<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Transactional
    public void add(final Author author) {
        this.authorRepository.save(author);
    }

    public void remove(final Long idAuthor) {
        this.authorRepository.delete(idAuthor);
    } 
    
	public Author findbyId(Long id) {
		return this.authorRepository.findOne(id);
	}

}
