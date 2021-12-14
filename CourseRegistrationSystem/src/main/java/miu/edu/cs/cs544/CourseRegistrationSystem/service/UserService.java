package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import java.util.List;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Role;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.User;

public interface UserService {
	
	User saveUser(User user);

	Role saveRole(Role role);

	void addRoleToUser(String username, String roleName);

	User getUser(String username);

	List<User> getUsers();
	
}
