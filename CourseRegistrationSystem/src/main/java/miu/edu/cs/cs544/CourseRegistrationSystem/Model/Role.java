package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name="role")
public class Role implements Serializable{
	
	private static final long serialVersionUID = 890245234L;
	
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private String name;
	




	

	

	public String getName() {
		return name;
	}


	public Role(String name) {
		super();
		this.name = name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();
	
	public Role(){}






	

	




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	
}
