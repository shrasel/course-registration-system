package miu.edu.cs.cs544.CourseRegistrationSystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class CourseOffering {
    @Id
    @GeneratedValue
    private int id;
    private String code;

    @OneToMany
    @JoinColumn(name="course_Id")
    private List<Course> course;

    @OneToMany
    private List<RegistrationRequest> registrationRequest;




}
