package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements UserDetails, Serializable{

	private static final long serialVersionUID = 902783495L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false, updatable = false)
	private int id;
	private String username;
	private String name;
	private String password;
	private String email;
	private String title;
	private String studentId;
	private boolean enabled = true;
	@OneToOne
	private Address emailAdress;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Address getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(Address emailAdress) {
		this.emailAdress = emailAdress;
	}



	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();



	

	


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username,String email2, String password2) {
		this.username=username;
		this.email=email2;
		this.password=password2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		userRoles.forEach(ur -> authorities.add(new SimpleGrantedAuthority(
				ur.getRole().getName())));
		return authorities;
	}
	


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean isAdmin() {

    	return checkRole("ROLE_ADMIN");    
    	}

    public boolean isProvider() {
    	return checkRole("ROLE_PROVIDER");
    }

    public boolean isClient() {

    	return checkRole("ROLE_CLIENT");    }

   
    
    private boolean checkRole(String role) {
        return userRoles.stream().filter(ur -> ur.getRole().getName().equals(role)).findAny().isPresent();
    }


	


	
	

	
	
	
}
