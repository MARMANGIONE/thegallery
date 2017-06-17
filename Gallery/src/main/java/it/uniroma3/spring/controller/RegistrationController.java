package it.uniroma3.spring.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.model.User;
import it.uniroma3.spring.service.UserService;



@Controller
public class RegistrationController {


	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/register")
	public String register(User user, Model model){
		return "register";
	}
	
	
	@PostMapping(value = "/register")
	public String register(@Valid @ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request, Model model){
        user.setEnabled(true);
	    User newUser = new User();
	    if (!bindingResult.hasErrors()) {
	        newUser = newAccount(user, bindingResult);
	    }
	   
	    if (newUser == null) {
	    	bindingResult.rejectValue("username", "Username.Existing");
	    }
		
		if(bindingResult.hasErrors()){
		    List<FieldError> errors = bindingResult.getFieldErrors();
		    for (FieldError error : errors ) {
		        System.out.println (error.getObjectName() + " - " + error.getDefaultMessage() + " - " + error.getField() + " - " + error.getCode());
		    }
		    model.addAttribute("user", user);
			return "/register";
		}else {
			model.addAttribute("user", newUser);
			model.addAttribute("InsertionSuccesful", true);
			return "/index";
	    }

	}
	
	
	private User newAccount(User user, BindingResult result) {
	    User newAccount = null;
	    try {
	        newAccount = userService.registerNewUser(user);
	    } catch (Exception e) {
	        return null;
	    }
	    return newAccount;
	}
}