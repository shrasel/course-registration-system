package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Registration {
    @Id
    @GeneratedValue
    private  int id;
    private  String studentId;
    private String courseId;

    @ManyToOne
    private CourseOffering courseOffering;

    public Registration() {
    }

    public Registration(int id, String studentId, String courseId, CourseOffering courseOffering) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.courseOffering = courseOffering;
    }
}
