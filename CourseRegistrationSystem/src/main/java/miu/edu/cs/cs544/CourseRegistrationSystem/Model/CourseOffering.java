package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

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

    public CourseOffering(int id, String code, int capacity, int nbOfRegisteredStudent, String faculty, AcademicBlock academicBlock, Course course, List<RegistrationRequest> registrationRequest) {
        this.id = id;
        this.code = code;
        this.capacity = capacity;
        this.nbOfRegisteredStudent = nbOfRegisteredStudent;
        this.faculty = faculty;
        this.academicBlock = academicBlock;
        this.course = course;
        this.registrationRequest = registrationRequest;
    }



}
