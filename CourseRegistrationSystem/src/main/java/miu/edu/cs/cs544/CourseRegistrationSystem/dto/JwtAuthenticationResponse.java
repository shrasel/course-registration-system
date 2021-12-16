package miu.edu.cs.cs544.CourseRegistrationSystem.dto;


import lombok.Getter;

@Getter
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private UserDTO user ;

    public JwtAuthenticationResponse(String accessToken, UserDTO userDetails) {
        this.accessToken = accessToken;
        this.user = userDetails;
    }

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
    
    

}
