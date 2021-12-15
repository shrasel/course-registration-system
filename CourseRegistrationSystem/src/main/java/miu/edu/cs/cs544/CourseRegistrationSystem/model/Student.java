package miu.edu.cs.cs544.CourseRegistrationSystem.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Student extends User {
	
	private String studentId;

	@ManyToOne
	private Address mailingAddress;

	@ManyToOne
	private Address homeAddress;

	@OneToMany
	private List<RegistrationRequest> registrationRequest;

}
