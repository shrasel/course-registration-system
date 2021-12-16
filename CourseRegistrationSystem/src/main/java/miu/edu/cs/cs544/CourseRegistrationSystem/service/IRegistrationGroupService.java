package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import miu.edu.cs.cs544.CourseRegistrationSystem.DTO.StudentDTO;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.AcadamicBlock;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Student;
import org.springframework.stereotype.Service;

@Service
public interface IRegistrationGroupService {
    public void addStudent(StudentDTO student);
    public void addBlock(int groupId, AcadamicBlock block);
    public void removeStudent(int groupId, int studentId);
    public void removeBlock(int groupId, AcadamicBlock block);
}
