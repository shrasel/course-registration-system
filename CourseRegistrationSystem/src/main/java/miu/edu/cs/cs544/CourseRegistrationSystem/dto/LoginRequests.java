package miu.edu.cs.cs544.CourseRegistrationSystem.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LoginRequests {

    private String email;
    private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	LoginRequests(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	LoginRequests() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
    

}
