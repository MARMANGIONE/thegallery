package it.uniroma3.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.model.User;
import it.uniroma3.spring.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	
	@GetMapping(value = "/register")
	public String register(User user, Model model){
		return "register";
	}
	
	@PostMapping(value = "/register")
	public String registraUtente(@Valid @ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request, @RequestParam(value = "Confirmation Password", required = false) String confirmationPassword,Model model){
		
		if(bindingResult.hasErrors()){
		    List<FieldError> errors = bindingResult.getFieldErrors();
		    for (FieldError error : errors ) {
		        System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
		    }
			return "/register";
		}
		if(userService.getUserByUsername(user.getUsername()) != null){
			if(userService.getUserByUsername(user.getUsername()).getUsername().equals(user.getUsername())){
				model.addAttribute("alreadyThere", true);
				model.addAttribute("confirmationPassword", confirmationPassword);
				return "/register";
			}
		}else{
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String password = passwordEncoder.encode(user.getPassword());
			user.setPassword(password);
			user.setEnabled(true);
			model.addAttribute(user);
			model.addAttribute("userInsert", true);
			return "/index";
		}
		return "/register";
	}
}