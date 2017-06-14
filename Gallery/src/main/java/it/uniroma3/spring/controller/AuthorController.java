package it.uniroma3.spring.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.model.Author;
import it.uniroma3.spring.service.AuthorService;

@Controller
public class AuthorController {
@Autowired
private AuthorService authorService;

@GetMapping("/author")
public String showForm(Author author){
	return "authorForm";
}

@PostMapping("/author")
public String checkPictureInfo(@Valid @ModelAttribute Author author,BindingResult bindingResult,Model model){
	if(bindingResult.hasErrors()) {
		return "authorForm";
	} else {
		model.addAttribute(author);
		authorService.add(author);
	}
	return "author";
}


}
