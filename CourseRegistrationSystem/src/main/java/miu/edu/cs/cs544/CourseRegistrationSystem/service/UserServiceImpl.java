package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Role;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.User;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.UserRole;
import miu.edu.cs.cs544.CourseRegistrationSystem.dto.RoleDTO;
import miu.edu.cs.cs544.CourseRegistrationSystem.dto.UserDTO;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.UserRepo;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	RoleService roleService;

	@Override
	public UserDTO findByEmail(String email) {
		return returnUserDTO(userRepo.findByEmail(email));
	}

	@Override
	@Transactional
	public ResponseEntity<?> createUser(User user) {

		if (userRepo.findByEmail(user.getEmail()) != null)
			return new ResponseEntity<String>("user with this Email : " + user.getEmail() + " exists ",
					HttpStatus.BAD_REQUEST);

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = roleService.findByName("ROLE_STUDENT");
		UserRole userRole = new UserRole(user, role);
		user.getUserRoles().add(userRole);
		return new ResponseEntity<UserDTO>(saveUser(user), HttpStatus.CREATED);

	}

	@Override
	public UserDTO updateUser(User user) {

		return saveUser(user);
	}

	@Override
	public ResponseEntity<?> addRoleToUser(int userId, RoleDTO role) {

		User user = userRepo.findById(userId).get();
		if (user == null)
			return null;
		Role r = roleService.findByName(role.getName());
		if (r == null)
			return null;

		boolean hasRole = false;
		for (UserRole ur : user.getUserRoles()) {
			if (ur.getRole().getName().equalsIgnoreCase(r.getName())) {
				hasRole = true;
				break;
			}
		}
		if (hasRole)
			return new ResponseEntity<String>(user.getEmail() + " has already a role : " + r.getName(),
					HttpStatus.BAD_REQUEST);

		UserRole ur = new UserRole(user, r);
		user.getUserRoles().add(ur);
		return new ResponseEntity<UserDTO>(saveUser(user), HttpStatus.OK);

	}

	private UserDTO returnUserDTO(User user) {
		if (user == null)
			return null;

		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		userDTO.setAuthorities((Set<GrantedAuthority>) user.getAuthorities());
		return userDTO;
	}

	private UserDTO saveUser(User user) {
		return returnUserDTO(userRepo.save(user));
	}

	@Override
	public Page<User> findAll(int page, int size) {
		Pageable p = PageRequest.of(page, size);
		return userRepo.findAll(p);
	}

	@Override
	public UserDTO findById(int id) {
		return returnUserDTO(userRepo.findById(id).get());
	}

	}


