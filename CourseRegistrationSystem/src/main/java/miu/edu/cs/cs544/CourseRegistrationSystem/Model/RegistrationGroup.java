package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;
import miu.edu.cs.cs544.CourseRegistrationSystem.Enum.Entry;
import miu.edu.cs.cs544.CourseRegistrationSystem.Enum.Track;
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
    private Entry entry;
    @Enumerated(EnumType.STRING)
    private Track Track;

   /* @OneToMany
    private List<Student> students;*/

   @OneToMany(cascade = CascadeType.ALL)
    private List<AcadamicBlock> acadamicBlockList;

    public void addBlock(AcadamicBlock block) {}
    public void removeStudent(int groupId, int studentId){}
    public void removeBlock(int groupId, AcadamicBlock block){}
}
