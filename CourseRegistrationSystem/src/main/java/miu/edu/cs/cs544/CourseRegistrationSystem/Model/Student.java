package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student extends  User{
    private String studentId;
    @ManyToOne
    private Address mailingAddress;
    @ManyToOne
    private Address HomeAddress;

    @OneToMany
    private Registration registration;

    @OneToMany
    private List<RegistrationRequest> registrationRequest;

}
