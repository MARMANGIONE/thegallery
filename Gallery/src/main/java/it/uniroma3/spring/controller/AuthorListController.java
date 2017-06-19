package it.uniroma3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import it.uniroma3.spring.service.AuthorService;

@Controller
public class AuthorListController {
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/showAuthorList")
	public String showAllAuthors(Model model) {
	    model.addAttribute("authors", authorService.findAll());
	    model.addAttribute("postMode","/showPictureByAuthor");
	    model.addAttribute("selectText","Author List");
	    model.addAttribute("onClickSelect","");
	    model.addAttribute("backPage","location.href='/'");
	    return "allAuthors";
	}
	

}
