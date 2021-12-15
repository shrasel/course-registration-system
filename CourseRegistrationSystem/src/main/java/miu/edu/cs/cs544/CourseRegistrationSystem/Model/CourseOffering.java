package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
public class CourseOffering {
    @Id
    @GeneratedValue
    private int id;
    private String code;
    private int capacity;
    private int nbOfRegisteredStudent;
    private String faculty;

    @ManyToOne
    @JoinColumn(name="acadamicBlockId")
    private AcademicBlock academicBlock;

    @ManyToOne()
    @JoinColumn(name="courseId")
    private Course course;

    @OneToMany
    @JoinColumn(name="courseOfferingId")
    private List<RegistrationRequest> registrationRequest;

    public CourseOffering(){}





}
