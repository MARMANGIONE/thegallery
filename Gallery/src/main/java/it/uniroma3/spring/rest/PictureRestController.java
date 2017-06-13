package it.uniroma3.spring.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.service.PictureService;

@RestController
public class PictureRestController {

		@Autowired
		PictureService pictureService;
		
	    @RequestMapping("/rest/picture/{id}")
	    public Picture getPicture(@PathVariable Long id) {
	        return pictureService.findbyId(id);
	    }
	}