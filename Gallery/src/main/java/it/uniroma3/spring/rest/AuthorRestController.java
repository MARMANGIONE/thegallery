package it.uniroma3.spring.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.spring.model.Author;
import it.uniroma3.spring.service.AuthorService;

@RestController
public class AuthorRestController {

		@Autowired
		AuthorService authorService;
		
	    @RequestMapping("/rest/author/{id}")
	    public Author getAuthor(@PathVariable Long id) {
	        return authorService.findbyId(id);
	    }
	}