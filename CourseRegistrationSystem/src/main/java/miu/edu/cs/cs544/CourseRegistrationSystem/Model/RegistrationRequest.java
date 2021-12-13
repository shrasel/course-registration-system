package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class RegistrationRequest {
    @Id
    @GeneratedValue
    private  int id;
    private int courseCode;
    private String priority;

    @ManyToOne
    private CourseOffering courseOffering;

}
