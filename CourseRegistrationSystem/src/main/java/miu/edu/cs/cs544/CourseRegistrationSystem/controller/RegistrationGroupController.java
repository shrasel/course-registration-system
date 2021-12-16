package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import miu.edu.cs.cs544.CourseRegistrationSystem.DTO.StudentDTO;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.AcadamicBlock;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Student;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl.RegistrationGroupServiceImpl;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registrationGroup")
public class RegistrationGroupController {

    @Autowired
    RegistrationGroupServiceImpl registrationGroupService;

    @Autowired
    StudentServiceImpl studentService;

    @PostMapping("/student/entry")
    public void addStudent(@RequestBody StudentDTO student){
        registrationGroupService.addStudent(student);
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
