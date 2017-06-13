package it.uniroma3.spring.controller;


import java.io.IOException;

import javax.validation.Valid;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.net.HttpHeaders;

import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.service.PictureService;


@Controller
public class PictureController {
@Autowired
private PictureService pictureService;

@GetMapping("/picture")
public String showForm(Picture picture){
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
	return "picture";
}


}



