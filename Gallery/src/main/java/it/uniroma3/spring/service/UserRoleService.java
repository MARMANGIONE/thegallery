package it.uniroma3.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.User;
import it.uniroma3.spring.model.UserRole;
import it.uniroma3.spring.repository.UserRoleRepository;


@Service
@Transactional
public class UserRoleService {

	@Autowired
	private UserRoleRepository repository;
	
	public UserRoleService(){
		
	}
	
	public void insertUserRole(UserRole ru){
		repository.save(ru);
	}
	
	public List<UserRole> getUserRoleByUser(User user){
		List<UserRole> roles = repository.findByUtente(user);
		return roles;
	}
	
	public List<UserRole> getUserRoleByUsername(String username){
		List<UserRole> roles = repository.findByUsername(username);
		return roles;
	}
}