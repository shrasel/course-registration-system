package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Role;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.RoleRepo;


@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepo roleRepo;

	@Override
	public Role findByName(String name) {
		
		return roleRepo.findByName(name);
	}

	@Override
	public Page<Role> findAll(int page, int size) {
		// TODO Auto-generated method stub

		Pageable p = PageRequest.of(page, size);
		return roleRepo.findAll(p);
	}

	@Override
	public Role addRole(String role) {
		String newRole ="ROLE_"+role;
		if(roleRepo.findByName(newRole) !=null)
			return null;
		return roleRepo.save(new Role(newRole));
	}

}
