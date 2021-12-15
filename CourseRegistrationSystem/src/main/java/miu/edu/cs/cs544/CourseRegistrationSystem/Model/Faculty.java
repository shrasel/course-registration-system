package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Faculty extends User {
    private String title;

    @OneToMany
   private List<Student> student;
}
