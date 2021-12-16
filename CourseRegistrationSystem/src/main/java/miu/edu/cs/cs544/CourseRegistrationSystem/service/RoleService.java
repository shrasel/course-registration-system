package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import org.springframework.data.domain.Page;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Role;



public interface RoleService {
	Role findByName(String name);
	Page<Role> findAll(int page, int size);
	Role addRole(String role);
}
