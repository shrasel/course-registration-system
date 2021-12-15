package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class RegistrationGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany
    private List<AcadamicBlock> acadamicBlockList;

    @OneToMany
    private  List<Student> students;
}
