package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
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


    @ManyToOne
    @JoinColumn(name="acadamicBlockId")
    private AcademicBlock academicBlock;

    @ManyToOne()
    @JoinColumn(name="courseId")
    private Course course;



    public CourseOffering(){}





}
