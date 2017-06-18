package it.uniroma3.spring.controller;

	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;

	// controller to access the personalArea
	@Controller
	public class PersonalAreaController {

	  // Login form
	  @RequestMapping("/personalArea")
	  public String login() {
	    return "personalArea";
	  }

	 


}
