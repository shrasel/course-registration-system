package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;


import miu.edu.cs.cs544.CourseRegistrationSystem.Model.User;
import miu.edu.cs.cs544.CourseRegistrationSystem.dto.RoleDTO;
import miu.edu.cs.cs544.CourseRegistrationSystem.dto.UserDTO;

public interface UserService {
	
	ResponseEntity<?> createUser(User user);
	UserDTO findByEmail(String email);
	UserDTO updateUser(User user);
	ResponseEntity<?> addRoleToUser(int userId, RoleDTO role);
	Page<User> findAll(int page, int size);
	UserDTO findById(int id);
	
//	User saveUser(User user);
//
//	Role saveRole(Role role);
//
//	void addRoleToUser(String username, String roleName);
//
//	User getUser(String username);
//
//	List<User> getUsers();
	
}
