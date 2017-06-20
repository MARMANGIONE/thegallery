package it.uniroma3.spring.controller;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.service.AuthorService;
import it.uniroma3.spring.service.PictureService;

	// controller to access the personalArea
	@Controller
	public class PersonalAreaController {

		@Autowired
		private AuthorService authorService;
		
		@Autowired
		private PictureService pictureservice;
	 
	  @RequestMapping("/personalArea")
	  public String personalArea() {
	    return "personalArea";
	  }

	  
	  @GetMapping("/pictureManagement")
		public String pictureManagement(Model model) {
		    model.addAttribute("opere", pictureservice.findAll());
		    model.addAttribute("postMode","/deletePicture");
		    model.addAttribute("selectText","Rimuovi");
		    model.addAttribute("onClickSelect","return confirm('Confermare la rimozione?')");
		    model.addAttribute("backPage","location.href='personalArea.html'");
		    model.addAttribute("mostraAzioni",true);
		    return "personalArea";
		}
	  
	  @PostMapping("/deletePicture")
		public String deletePicture(@RequestParam("idOpera") long idOpera, Model model) {
		    pictureservice.remove(idOpera);
		    return pictureManagement(model);
		}
	 
	  @GetMapping("/authorListManagement")
		public String authorListManager(Model model) {
		    model.addAttribute("authors", authorService.findAll());
		    model.addAttribute("postMode","/deleteAuthor");
		    model.addAttribute("selectText","Delete");
		    model.addAttribute("onClickSelect","return confirm('All associated pictures will be deleted. Are you sure?')");
		    model.addAttribute("backPage","location.href='personalArea.html'");
		    return "personalArea";
		}
	  
	  @GetMapping("/chooseAuthor")
		public String chooseAuthor(Model model) {
		    model.addAttribute("authors", authorService.findAll());
		    model.addAttribute("postMode","/chooseAuthor");
		    model.addAttribute("selectText","Select");
		    model.addAttribute("onClickSelect","");
		    model.addAttribute("backPage","location.href='personalArea.html'");
		    return "personalArea";
		}
		
		@PostMapping("/removeAuthor")
		public String authorRemove(@RequestParam("authorId") long authorId, Model model) {
		    authorService.remove(authorId);
		    return authorListManager(model);
		}



}