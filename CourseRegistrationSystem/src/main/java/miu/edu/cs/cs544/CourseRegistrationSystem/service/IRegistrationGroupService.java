package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import miu.edu.cs.cs544.CourseRegistrationSystem.Enum.Group;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.AcademicBlock;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.RegistrationGroup;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Student;
import org.springframework.stereotype.Service;

@Service
public interface IRegistrationGroupService {

    public RegistrationGroup getGroup(Group name);
    public void addRegistrationGroup(RegistrationGroup registrationGroup);
    public void deleteRegistrationGroup(Integer id);


    public void addStudent(int groupId, Student student);
    public void addBlock(int groupId, AcademicBlock block);
    public void removeStudent(int groupId, int studentId);
    public void removeBlock(int groupId, AcademicBlock block);
}
