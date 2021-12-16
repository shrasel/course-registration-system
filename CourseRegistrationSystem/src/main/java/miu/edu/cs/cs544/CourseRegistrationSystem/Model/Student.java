package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student{
    @Id
    @GeneratedValue
    private  int id;
    private String name;
    private String email;
    private String studentId;
    private String mailingAddress;

    private String homeAddress;

  /* @OneToMany
    private List<Registration>registration;

    @OneToMany
    private List<RegistrationRequest> registrationRequest;
*/
}
