package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;
import miu.edu.cs.cs544.CourseRegistrationSystem.Enum.Group;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class RegistrationGroup {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Group group;

    @OneToMany
    private List<Student> students;

   @OneToMany(cascade = CascadeType.ALL)
    private List<AcademicBlock> acadamicBlockList;

    public void addStudent(Student Student) {}
    public void addBlock(AcademicBlock block) {
        this.acadamicBlockList.add(block);
    }
    public void removeStudent(int groupId, int studentId){}
    public void removeBlock(int groupId, AcademicBlock block){}
}
