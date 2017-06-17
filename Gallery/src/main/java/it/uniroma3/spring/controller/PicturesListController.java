package it.uniroma3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.service.AuthorService;
import it.uniroma3.spring.service.PictureService;

public class PicturesListController {
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private PictureService pictureService;
	
	@GetMapping("/showAllPictures")
	public String showAll(Model model) {
	    model.addAttribute("pictures", pictureService.findAll());
	    model.addAttribute("postMode","/showPicturesByAuthor");
	    model.addAttribute("selectText","Lista opere dell'autore");
	    model.addAttribute("onClickSelect","");
	    model.addAttribute("backPage","location.href='/'");
	    model.addAttribute("mostraAzioni",true);
	    return "allPictures";
	}
	
	@PostMapping("/showPicturesByAuthor")
	public String showPicturesByAuthor(@RequestParam("authorId") long authorId, Model model) {
	    model.addAttribute("pictures", pictureService.findByAuthor(authorService.findbyId(authorId)));
	    model.addAttribute("mostraAzioni",false);
	    model.addAttribute("backPage","history.go(-1);");
	    return "allPictures";
	}
	
	@GetMapping("/pictureManagement")
	public String pictureManager(Model model) {
	    model.addAttribute("pictures", pictureService.findAll());
	    model.addAttribute("postMode","/delectePicture");
	    model.addAttribute("selectText","Delete");
	    model.addAttribute("onClickSelect","return confirm('Are you sure you want to remove it?')");
	    model.addAttribute("backPage","location.href='/Allpictures'");
	    model.addAttribute("mostraAzioni",true);
	    return "allPictures";
	}
	
	@PostMapping("/deletePicture")
	public String rimuoviOpera(@RequestParam("pictureId") long pictureId, Model model) {
		Picture picture = pictureService.findbyId(pictureId);
		picture.getAuthor().removePicture(picture);
	    pictureService.remove(pictureId);
	    return pictureManager(model);
	}
}

