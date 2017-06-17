package it.uniroma3.spring.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.User;
import it.uniroma3.spring.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired    
	private UserRepository userRepository;

	public UserService() {
		
	}
	
	public void insertUsername(User user) {
		userRepository.save(user);
	}

	
	public User getOneUser(Long id) {
		User user = userRepository.findOne(id);
		return user;
	}

	public void delete(User u){
		userRepository.delete(u);
	}
	
	public User getUserByEmail(String email){
		User user = userRepository.findByEmail(email);
		return user;
	}
	
	public User getUserByUsername(String username){
		User user = userRepository.findByUsername(username);
		return user;
	}
	
	public User registerNewUser(User user) throws Exception {
         
        if (findUsername(user.getUsername())) {   
            throw new Exception("Username gia' esistente");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
        return userRepository.save(user);       
    }
    
    
    private boolean findUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return true;
        }
        return false;
    }
	
}
