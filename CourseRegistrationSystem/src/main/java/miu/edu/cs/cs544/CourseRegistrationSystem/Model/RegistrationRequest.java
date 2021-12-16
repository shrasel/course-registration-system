package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class RegistrationRequest {
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

}
