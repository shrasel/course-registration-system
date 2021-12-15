package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class RegistrationRequest {
    @Id
    @GeneratedValue
    private  int id;
    private String courseCode;
    private int priority;

    @ManyToOne
    private Registration registration;

    public RegistrationRequest() {
    }

    public RegistrationRequest(int id, String courseCode, int priority, Registration registration) {
        this.id = id;
        this.courseCode = courseCode;
        this.priority = priority;
        this.registration = registration;
    }
}
