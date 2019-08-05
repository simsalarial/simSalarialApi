package simSalProject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.User_;
import simSalProject.models.User_.UserRole;
import simSalProject.repositories.UserRepository;

@Named("UserBus")
@RequestScoped
public class UserBusiness  {
	
	
	@Inject
	@Named("UserRep")
	UserRepository USER_DB;
	
	
	public String createUser(User_ myUser) {
		if(myUser.getUserRole() == UserRole.USER) {
			USER_DB.createEntity(myUser);	
			
		} else if (myUser.getUserRole() == UserRole.ADMIN) {
			return "Only 1 admin can exist";
		}
		return "User created";
	}
	
	public String createAdmin(User_ adminUser) {
		USER_DB.createEntity(adminUser);
		return "ADMIN didn't exist, ADMIN created with default credentials";
	}
	
	
	public User_ consultUser(long id) {
		User_ myUser = USER_DB.consultEntity(id);
		return myUser;
	}
	
	public void editUser(long id, User_ myUserToEdit) {
		if (myUserToEdit.getUserRole() != UserRole.ADMIN) {
			USER_DB.editEntity(myUserToEdit);
		}
	}
	
	public void removeUser(User_ myUser) {
		if (myUser.getUserRole() != UserRole.ADMIN) {
			USER_DB.removeEntity(myUser);
		}
	}
	
	public List<Long> getAllIds() {
		return new ArrayList<Long>(USER_DB.allIds());
	}
	
	public Collection<User_> getAllValues() {
		return USER_DB.allValues();
	}
	
	public String initDataBase() {
		String message = "";
		//0 is ENUM(0), which is ADMIN
		if (USER_DB.getRoleCount(UserRole.ADMIN) == 0){
			User_ initUser = new User_();
			initUser.setEmail("admin@admin.com");
			initUser.setPassword("admin");
			initUser.setUserRole(UserRole.ADMIN);
			message = createAdmin(initUser);
			
		} else {
			message = "ADMIN already exists";
		}
		
		return message;
	}
	
	public String login() {
		
		
		
		return "";
		
	}
	
	
}
