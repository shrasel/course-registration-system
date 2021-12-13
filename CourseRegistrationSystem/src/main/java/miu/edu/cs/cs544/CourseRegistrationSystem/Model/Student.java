package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Data
public class Student extends  User{
    private String studentId;
    @Transient
    private Address mailingAddress;
    @Transient
    private Address HomeAddress;
    @Transient
    private Registration registration;

}
