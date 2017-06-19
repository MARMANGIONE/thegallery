package it.uniroma3.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import it.uniroma3.spring.service.AuthorService;
import it.uniroma3.spring.service.PictureService;

@Controller
public class PicturesListController {
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private PictureService pictureservice;
	
	@GetMapping("/showAllPictures")
	public String visualizzaElenco(Model model) {
	    model.addAttribute("pictures", pictureservice.findAll());
	    model.addAttribute("postMode","/showPictureByAuthor");
	    model.addAttribute("selectText","Elenco opere dell'autore");
	    model.addAttribute("onClickSelect","");
	    model.addAttribute("backPage","location.href='index.html'");
	    model.addAttribute("mostraAzioni",true);
	    return "allPictures";
	}
	
	@PostMapping("/showPictureByAuthor")
	public String visualizzaElencoOpereAutore(@RequestParam("idAuthor") long idAuthor, Model model) {
	    model.addAttribute("opere", pictureservice.findByAuthor(authorService.findbyId(idAuthor)));
	    model.addAttribute("mostraAzioni",false);
	    model.addAttribute("backPage","history.go(-1);");
	    return "allPictures";
	}
	

}