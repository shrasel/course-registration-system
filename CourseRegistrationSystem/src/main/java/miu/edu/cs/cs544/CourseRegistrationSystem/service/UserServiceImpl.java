package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.edu.cs.cs544.CourseRegistrationSystem.model.Role;
import miu.edu.cs.cs544.CourseRegistrationSystem.model.User;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.RoleRepository;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
//public class UserServiceImpl implements UserService {
//
//	private final UserRepository userRepo;
//	private final RoleRepository roleRepo;
//
//	@Override
//	public User saveUser(User user) {
//		log.info("Saving  new user {} to the database",user.getName());
//		return userRepo.save(user);
//	}
//
//	@Override
//	public Role saveRole(Role role) {
//		log.info("Saving  new role {} to the database",role.getName());
//		return roleRepo.save(role);
//	}
//
//	@Override
//	public void addRoleToUser(String username, String roleName) {
//		log.info("Adding role {}  to user {}",roleName, username);
//		User user = userRepo.findByUsername(username);
//		Role role = roleRepo.findByName(roleName);
//		user.getRoles().add(role);
//
//	}
//
//	@Override
//	public User getUser(String username) {
//		log.info("Fetching user {} from database", username);
//		return userRepo.findByUsername(username);
//	}
//
//	@Override
//	public List<User> getUsers() {
//		 log.info("Fetching all user");
//		return userRepo.findAll();
//	}
//
//}
