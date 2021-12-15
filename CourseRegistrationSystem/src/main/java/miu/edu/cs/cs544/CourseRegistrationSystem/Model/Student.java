package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Student extends User {
  /*  @Id
    @GeneratedValue
    private  int id;
    private String name;
    private String email;*/
    private String studentId;
    /*private String mailingAddress;

    private String homeAddress;
   */

        @ManyToOne
        private Address mailingAddress;

        @ManyToOne
        private Address homeAddress;

        @OneToMany(cascade = CascadeType.ALL)
        private List<RegistrationRequest> registrationRequest;



}
