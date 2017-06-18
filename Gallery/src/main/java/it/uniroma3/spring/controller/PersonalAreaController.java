package it.uniroma3.spring.controller;

	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;

	// controller to access the personalArea
	@Controller
	public class PersonalAreaController {

	 
	  @RequestMapping("/personalArea")
	  public String personalArea() {
	    return "personalArea";
	  }

	 


}