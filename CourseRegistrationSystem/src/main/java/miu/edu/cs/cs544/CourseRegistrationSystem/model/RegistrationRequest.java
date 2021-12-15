package miu.edu.cs.cs544.CourseRegistrationSystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class RegistrationRequest {
    @Id
    @GeneratedValue
    private  int id;
    private int courseCode;
    private String priority;

    @OneToMany
    private List<Registration> registration;

    /*@ManyToOne
    private CourseOffering courseOffering;*/

}
