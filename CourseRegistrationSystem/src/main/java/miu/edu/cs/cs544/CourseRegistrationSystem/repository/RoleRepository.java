package miu.edu.cs.cs544.CourseRegistrationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
