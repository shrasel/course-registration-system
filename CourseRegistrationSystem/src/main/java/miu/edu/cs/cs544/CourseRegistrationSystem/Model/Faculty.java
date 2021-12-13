package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Data
public class Faculty extends User{
    private String title;

    @OneToMany
   private List<Student> student;
}
