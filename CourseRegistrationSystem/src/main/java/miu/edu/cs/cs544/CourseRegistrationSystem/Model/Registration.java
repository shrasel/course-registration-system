package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Data
public class Registration {
    @Id
    @GeneratedValue
    private  int id;
    private String courseCode;
    private int priority;
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name="courseOffering_id")
    private CourseOffering courseOffering;

    public Registration(String courseCode, int priority, Student student, CourseOffering courseOffering) {
        this.courseCode = courseCode;
        this.priority = priority;
        this.student = student;
        this.courseOffering = courseOffering;
    }
}
