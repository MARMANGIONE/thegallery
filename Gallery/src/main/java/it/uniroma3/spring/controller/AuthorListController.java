package it.uniroma3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/chooseAuthor")
	public String chooseAuthor(Model model) {
	    model.addAttribute("authors", authorService.findAll());
	    model.addAttribute("postMode","/chooseAuthor");
	    model.addAttribute("selectText","Select");
	    model.addAttribute("onClickSelect","");
	    model.addAttribute("backPage","location.href='personalArea.html'");
	    return "allAuthors";
	}
	
	@PostMapping("/removeAuthor")
	public String authorRemove(@RequestParam("idAuthor") long idAuthor, Model model) {
	    authorService.remove(idAuthor);
	    return authorListManager(model);
	}
	
	  @GetMapping("/authorListManagement")
			public String authorListManager(Model model) {
			    model.addAttribute("authors", authorService.findAll());
			    model.addAttribute("postMode","/removeAuthor");
			    model.addAttribute("selectText","Delete");
			    model.addAttribute("onClickSelect","return confirm('All associated pictures will be deleted. Are you sure?')");
			    model.addAttribute("backPage","location.href='personalArea.html'");
			    return "allAuthors";
			}
	
	

}
