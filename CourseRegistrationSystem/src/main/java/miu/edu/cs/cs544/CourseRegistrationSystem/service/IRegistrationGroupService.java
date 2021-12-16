package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import miu.edu.cs.cs544.CourseRegistrationSystem.DTO.StudentDTO;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.AcadamicBlock;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.RegistrationGroup;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRegistrationGroupService {
    //---------------Start Crud=======================//
    public RegistrationGroup getRegById(Integer id);
    public List<RegistrationGroup> getAllReg();
    public void addRegistrationGroup(RegistrationGroup registrationGroup);
    public  RegistrationGroup updateReg(Integer id,RegistrationGroup registrationGroup);
    public void deleteRegistrationGroup(int id);
    //-------------------End Crud=======================//
    public void addStudent(StudentDTO student);
    public void addBlock(int groupId, AcadamicBlock block);
    public void removeStudent(int groupId, int studentId);
    public void removeBlock(int groupId, AcadamicBlock block);
}
