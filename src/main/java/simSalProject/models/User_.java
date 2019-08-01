package simSalProject.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity
@NamedQueries({
	@NamedQuery(name=User_.ALL_USER_IDS, query="SELECT u.id FROM User_ u"),
	@NamedQuery(name=User_.ALL_USER_VALUES, query="SELECT u FROM User_ u"),
	@NamedQuery(name=User_.GET_USER_BY_ID, query="SELECT u FROM User_ u WHERE u.id = :id")
})
public class User_ extends Entity_{
	private static final long serialVersionUID = 1L;
	public static final String ALL_USER_IDS = "getUserIds";
	public static final String ALL_USER_VALUES = "getAllUsers";
	public static final String GET_USER_BY_ID = "getUserById";
	
	private enum UserRole {
	    OWNER, ADMIN, BASEUSER, 
	}
	
	private String email;
	private String password;
	private UserRole userRole;
	
	public User_() {}

	public User_(String email, String password, UserRole role ) {
		this.email = email;
		this.password = password;
		this.userRole = role;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public UserRole getUserRole() {
		return userRole;
	}
}