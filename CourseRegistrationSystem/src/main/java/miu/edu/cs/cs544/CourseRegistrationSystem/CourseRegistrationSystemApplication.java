package miu.edu.cs.cs544.CourseRegistrationSystem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Role;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.User;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.UserRole;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.UserRepo;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.UserService;

@SpringBootApplication
@EnableTransactionManagement
public class CourseRegistrationSystemApplication {
	

	@Autowired
	UserRepo userRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CourseRegistrationSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args->{
			Role roleAdmin = new Role("ROLE_ADMIN");
			Role roleStudent = new Role("ROLE_STUDENT");
			Role roleFaculty = new Role("ROLE_FACULTY");
			User admin = new User();
			admin.setEmail("shahjahan@gmail.com");
			admin.setPassword(passwordEncoder.encode("shahjahan"));
			admin.setUsername("Shahja");
			
			UserRole ura = new UserRole(admin,roleAdmin);
			UserRole urp = new UserRole(admin,roleStudent);
			UserRole urc = new UserRole(admin,roleFaculty);
			admin.getUserRoles().addAll(Arrays.asList(ura,urp,urc));
			userRepo.save(admin);

		};
	}

}
