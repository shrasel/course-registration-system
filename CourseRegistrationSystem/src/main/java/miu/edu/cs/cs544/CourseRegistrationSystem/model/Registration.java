package miu.edu.cs.cs544.CourseRegistrationSystem.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Registration {
    @Id
    @GeneratedValue
    private  int id;
    private  int studentId;
    private int courseId;

    @ManyToOne
    private CourseOffering courseOffering;
}
