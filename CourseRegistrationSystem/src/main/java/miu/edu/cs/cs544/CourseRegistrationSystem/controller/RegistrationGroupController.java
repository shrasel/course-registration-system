package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.AcadamicBlock;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Student;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl.RegistrationGroupServiceImpl;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrationGroup")
public class RegistrationGroupController {

    @Autowired
    RegistrationGroupServiceImpl registrationGroupService;

    @Autowired
    StudentServiceImpl studentService;

    @PostMapping("/student/entry/track")
    public void addStudent(int groupId , Student student){
        registrationGroupService.addStudent(groupId,student);
    }

    @DeleteMapping("/student/entry/track/id")
    public void removeStudent(int groupId, int studentId){
      registrationGroupService.removeStudent(groupId,studentId);
    }

    @PostMapping("/acadamicBlock/entry/track")
    public void addAcadamicBlock(int groupId, AcadamicBlock block){
        registrationGroupService.addBlock(groupId, block);
    }

   @DeleteMapping("acadamicBlock/entry/track/id")
    public void removeAcadamicBlock(int groupId,AcadamicBlock block ){
        registrationGroupService.removeBlock(groupId,block);
   }

}
