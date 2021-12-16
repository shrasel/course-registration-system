package miu.edu.cs.cs544.CourseRegistrationSystem.dto;

public class RegistrationRequest {
	private String username;
	private String email;
	private String password;
	private String passwordConfirmation;
	
	
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	RegistrationRequest(String email, String password, String passwordConfirmation) {
		super();
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
	}
	RegistrationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
