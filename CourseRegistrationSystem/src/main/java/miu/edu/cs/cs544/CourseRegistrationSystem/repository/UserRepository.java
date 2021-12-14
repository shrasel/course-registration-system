package miu.edu.cs.cs544.CourseRegistrationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
