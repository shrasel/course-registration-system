package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import javax.persistence.OneToMany;
import java.util.List;

public class RegistrationGroup {
    private int id;
    private String name;

    @OneToMany
    private List<AcademicBlock> acadamicBlockList;

    @OneToMany
    private  List<Student> students;
}
