package it.uniroma3.spring.controller;


import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.model.Author;
import it.uniroma3.spring.service.AuthorService;

@Controller
public class AuthorController {
@Autowired
private AuthorService authorService;

@GetMapping("/author")
public String mostraForm(Author author) {
	return "authorForm";
}

@PostMapping("/author")
public String controllaDatiAutore(@Valid @ModelAttribute Author author, BindingResult bindingResult, Model model) {

	if (bindingResult.hasErrors()) {
		return "authorForm";
	} else {
		model.addAttribute(author);
		authorService.add(author);
	}
	return "authorResult";
}


@InitBinder
private void dateBinder(WebDataBinder binder) {
    //The date format to parse or output your dates
SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    //Create a new CustomDateEditor
CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
    //Register it as custom editor for the Date type
binder.registerCustomEditor(Date.class, editor);
}

}

