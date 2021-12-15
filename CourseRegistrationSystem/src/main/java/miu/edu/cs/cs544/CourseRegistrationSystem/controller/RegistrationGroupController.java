package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import miu.edu.cs.cs544.CourseRegistrationSystem.Enum.Group;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.AcademicBlock;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.RegistrationGroup;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Student;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl.AcademicBlockServiceImpl;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl.RegistrationGroupServiceImpl;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrationGroup")
public class RegistrationGroupController {

    @Autowired
    RegistrationGroupServiceImpl registrationGroupService;

    @Autowired
    AcademicBlockServiceImpl academicBlockService;

    @Autowired
    StudentServiceImpl studentService;


    @PostMapping("/student/group")
    public void addStudent(int groupId , Student student){
        registrationGroupService.addStudent(groupId,student);
    }

    @DeleteMapping("/student/group/{id}")
    public void removeStudent(int groupId, int studentId){
      registrationGroupService.removeStudent(groupId,studentId);
    }

    @GetMapping("/{name}")
    public RegistrationGroup getGroup(@PathVariable String name){
        Group group=Group.Aug;
        switch (name){
            case "Aug":
            { group=Group.Aug; break;}
            case "Feb":
            {group=Group.Feb; break;}
            case "May":
            { group=Group.May; break;}
            case "Nov":
            { group=Group.Nov; break;}
            case "Mpp":
            { group=Group.Mpp; break;}
            default:
            { group=Group.Fpp; break;}
        }
        return registrationGroupService.getGroup(group);
    }
    @PostMapping
    public void addRegistrationGroup(@RequestBody RegistrationGroup registrationGroup){
        registrationGroupService.addRegistrationGroup(registrationGroup);
    }

    @PostMapping("/{group}/{academicBlockId}")
    public void addAcadamicBlock(@PathVariable String group, @PathVariable int academicBlockId){
        AcademicBlock academicBlock=academicBlockService.getOne(academicBlockId);
        RegistrationGroup registrationGroup=getGroup(group);
        registrationGroup.addBlock(academicBlock);

        registrationGroupService.addRegistrationGroup(registrationGroup);
    }

   @DeleteMapping("acadamicBlock/group/{academicBlockId}")
    public void removeAcadamicBlock(@PathVariable String group,@PathVariable int academicBlockId){
        AcademicBlock academicBlock=academicBlockService.getOne(academicBlockId);
        RegistrationGroup registrationGroup=getGroup(group);
       // registrationGroup.removeBlock(academicBlock);
       // registrationGroupService.removeBlock(groupId,block);
   }

}
