package it.uniroma3.spring.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.User;
import it.uniroma3.spring.model.UserRole;


public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
	
	List<UserRole> findByUtente(User user);
	List<UserRole> findByUsername(String username);
}