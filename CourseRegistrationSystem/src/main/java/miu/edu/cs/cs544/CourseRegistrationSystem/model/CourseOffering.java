package miu.edu.cs.cs544.CourseRegistrationSystem.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;


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
    private AcadamicBlock academicBlock;

    @ManyToOne()
    @JoinColumn(name="courseId")
    private Course course;

    @OneToMany
    @JoinColumn(name="courseOfferingId")
    private List<RegistrationRequest> registrationRequest;

    public CourseOffering(){}

    public CourseOffering(int id, String code, int capacity, int nbOfRegisteredStudent, String faculty, AcadamicBlock academicBlock, Course course, List<RegistrationRequest> registrationRequest) {
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
