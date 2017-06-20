package it.uniroma3.spring.controller;



import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.model.Author;
import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.service.AuthorService;
import it.uniroma3.spring.service.PictureService;


@Controller
public class PictureController {

@Autowired
private PictureService pictureService;
@Autowired
private AuthorService authorService;

@PostMapping("/chooseAuthor")
public String newForm(@RequestParam("idAuthor") long idAuthor, Model model, Picture picture) {
	Author a = authorService.findbyId(idAuthor);
	picture.setAuthor(a);
	return "pictureForm";
}
@PostMapping("/picture")
public String checkPictureInfo(@Valid @ModelAttribute Picture picture,BindingResult bindingResult,Model model){
	if(bindingResult.hasErrors()) {
		return "pictureForm";
	} else {
		model.addAttribute(picture);
		pictureService.add(picture);
	}
	return "pictureResult";
}


}



