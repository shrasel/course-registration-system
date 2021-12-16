package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Role;
import miu.edu.cs.cs544.CourseRegistrationSystem.dto.RoleDTO;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.RoleService;

@RestController

@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	RoleService roleService;

	@GetMapping("")
	//@PreAuthorize("hasRole('ADMIN')")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public Page<Role> getAllRoles(@RequestParam(value = "page", defaultValue = "0", required = false) int page, @RequestParam(value = "size", defaultValue = "20", required = false) int size){
		return roleService.findAll(page,size);
	}
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public Role addRole(@RequestBody RoleDTO role){
		
		 return roleService.addRole(role.getName());
	}
}
