package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String Code;
    @OneToOne
    private Address mailingAddress;
    @OneToOne
    private Address HomeAddress;


}
