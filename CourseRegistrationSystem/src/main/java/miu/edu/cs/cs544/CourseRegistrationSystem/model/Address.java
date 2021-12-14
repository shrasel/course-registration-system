package miu.edu.cs.cs544.CourseRegistrationSystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String city;
    private String postalCode;
    private String state;
    private String country;

    @OneToMany
    @JoinColumn(name="studentId")
    private List<Student> students;
}
