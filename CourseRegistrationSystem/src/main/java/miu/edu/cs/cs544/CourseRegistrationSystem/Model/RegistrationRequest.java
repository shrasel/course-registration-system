package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class RegistrationRequest {
    @Id
    @GeneratedValue
    private  int id;
    private int courseCode;
    private String priority;

    @OneToMany
    private Registration registration;

    /*@ManyToOne
    private CourseOffering courseOffering;*/

}
