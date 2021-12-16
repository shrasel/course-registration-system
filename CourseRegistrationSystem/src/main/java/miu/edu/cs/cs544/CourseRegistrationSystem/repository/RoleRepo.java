package miu.edu.cs.cs544.CourseRegistrationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Role;


@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

	Role findByName(String name);
	
}
