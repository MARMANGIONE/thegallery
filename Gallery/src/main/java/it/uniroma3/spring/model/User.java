package it.uniroma3.spring.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Table(name = "\"User\"")
@Entity
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min = 1)
	private String username;
	@NotNull
	@Size(min = 1)
	private String password;
	private boolean enabled;
	@Size(min = 1)
	@NotNull
	private String email;
	@Size(min = 1)
	@NotNull
	private String name;
	@Size(min = 1)
	@NotNull
	private String lastname;
	@OneToMany(mappedBy = "user")
	private List<UserRole> userRoles;

	
	public User(String email, String password, String name, String lastname, boolean enabled, List<UserRole> userRoles){
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.enabled = enabled;
		this.userRoles = userRoles;
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(){
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setCognome(String lastname) {
		this.lastname = lastname;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setRuoliUtente(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
}
