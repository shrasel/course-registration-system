package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
}
