package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.User;
import miu.edu.cs.cs544.CourseRegistrationSystem.dto.JwtAuthenticationResponse;
import miu.edu.cs.cs544.CourseRegistrationSystem.dto.LoginRequests;
import miu.edu.cs.cs544.CourseRegistrationSystem.dto.RegistrationRequest;
import miu.edu.cs.cs544.CourseRegistrationSystem.dto.UserDTO;
import miu.edu.cs.cs544.CourseRegistrationSystem.jwt.JwtTokenProvider;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.UserService;
import miu.edu.cs.cs544.CourseRegistrationSystem.validator.EmailValidator;


@RestController
@RequestMapping("/api/")
public class AuthenticationController {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider tokenProvider;
	@Autowired
	EmailValidator emailValidator;

	private static String INVALID_EMAIL = "Invalide email";
	private static String INVALID_EMAIL_OR_PASSWORD = "Incorrect email Or password ";
	private static String DISABLED = "Account Disabled";
	private static String INCORRECT_CONFIRMATION_PASSWORD = "Password confirmation not the same";

	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody LoginRequests loginRequest) throws Exception {
		boolean isValidEmail = emailValidator.test(loginRequest.getEmail());
		if (!isValidEmail) {
			return error(INVALID_EMAIL);
		}
		final ResponseEntity<String> response = authenticate(loginRequest.getEmail(), loginRequest.getPassword());
		if (response != null)
			return response;
		User user = (User) userDetailsService.loadUserByUsername(loginRequest.getEmail());
		if (user == null)
			return error(INVALID_EMAIL_OR_PASSWORD);
		String token = jwtTokenProvider.generateToken(user);
		UserDTO userDto = new UserDTO(user.getId(), user.getUsername(), user.getEmail(), true,
				(Set<GrantedAuthority>) user.getAuthorities());
		JwtAuthenticationResponse res = new JwtAuthenticationResponse(token, userDto);

		return new ResponseEntity<JwtAuthenticationResponse>(res, HttpStatus.OK);

	}
	

	private ResponseEntity<String> authenticate(String username, String password) throws Exception {
		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (DisabledException e) {
			return error(DISABLED);

		} catch (BadCredentialsException e) {
			return error(INVALID_EMAIL_OR_PASSWORD);
		}
		return null;
	}

	@PostMapping("register")
	public ResponseEntity<?> register(@RequestBody RegistrationRequest req) {

		if (!isValidEmail(req.getEmail())) {
			return error(INVALID_EMAIL);
		}
		if (!req.getPassword().equals(req.getPasswordConfirmation())) {
			return error(INCORRECT_CONFIRMATION_PASSWORD);
		}
		return userService.createUser(new User(req.getUsername(), req.getEmail(), req.getPassword()));

	}

	private boolean isValidEmail(String email) {
		return emailValidator.test(email);
	}

	private ResponseEntity<String> error(String message) {
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
}
