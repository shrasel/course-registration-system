package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student extends User {
    @Column(nullable = false)
    private String studentId;

    @OneToMany
    private List<RegistrationRequest> registrationRequest;

    public Student() {
    }

    public Student(Integer id, String name, String email, String role, String username, String password, Address address, String studentId) {
        super(id, name, email, role, username, password, address);
        this.studentId = studentId;
    }
}
