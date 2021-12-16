package miu.edu.cs.cs544.CourseRegistrationSystem.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.User;



@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	

}
