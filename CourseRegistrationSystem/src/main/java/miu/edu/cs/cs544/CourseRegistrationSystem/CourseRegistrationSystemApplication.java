package miu.edu.cs.cs544.CourseRegistrationSystem;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Role;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.User;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.UserService;

@SpringBootApplication
public class CourseRegistrationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseRegistrationSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args->{
			userService.saveRole(new Role(null,"ROLE_STUDENT"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_FACULTY"));
			
			userService.saveUser(new User(null,"Shahjahan Rasel", "rasel", "123456", new ArrayList<>()));
			userService.saveUser(new User(null,"John Doe", "john", "123456", new ArrayList<>()));
			userService.saveUser(new User(null,"Fatema Akter", "fatema", "123456", new ArrayList<>()));
			userService.saveUser(new User(null,"Payman Salek", "payman", "123456", new ArrayList<>()));
			userService.saveUser(new User(null,"Mel Gibson", "gibson", "123456", new ArrayList<>()));

			userService.addRoleToUser("rasel", "ROLE_STUDENT");
			userService.addRoleToUser("john", "ROLE_STUDENT");
			userService.addRoleToUser("fatema", "ROLE_STUDENT");
			userService.addRoleToUser("payman", "ROLE_FACULTY");
			userService.addRoleToUser("gibson", "ROLE_ADMIN");


		};
	}

}
