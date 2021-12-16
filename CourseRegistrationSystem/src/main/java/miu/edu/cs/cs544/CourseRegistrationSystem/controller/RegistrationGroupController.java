package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import miu.edu.cs.cs544.CourseRegistrationSystem.DTO.StudentDTO;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.AcadamicBlock;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.RegistrationGroup;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Student;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl.RegistrationGroupServiceImpl;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrationGroup")
public class RegistrationGroupController {

    @Autowired
    RegistrationGroupServiceImpl registrationGroupService;

    @Autowired
    StudentServiceImpl studentService;
    //==========================Crud======================================//
    @GetMapping("/{id}")
    public RegistrationGroup getOneRegById(@PathVariable Integer id) {
        return registrationGroupService.getRegById(id);
    }
    @GetMapping
    public List<RegistrationGroup> getAllReg(){
        return registrationGroupService.getAllReg();
    }
     @PutMapping("/{id}")
    public ResponseEntity<?> updateReg(@PathVariable Integer id, @RequestBody RegistrationGroup registrationGroup) {
        RegistrationGroup reg = registrationGroupService.updateReg(id,registrationGroup);
        if (reg == null)
            return new ResponseEntity<>("Id not found", HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(reg, HttpStatus.OK);
    }
   /* @PutMapping("/{id}")
    public RegistrationGroup updateReg(@PathVariable Integer id, @RequestBody RegistrationGroup registrationGroup) {
        return registrationGroupService.updateReg(id,registrationGroup);
    }*/
    @PostMapping
    public void addRegistrationGroup(@RequestBody RegistrationGroup registrationGroup){
        registrationGroupService.addRegistrationGroup(registrationGroup);
    }

    @DeleteMapping("/{id}")
   public void deleteRegistrationGroup(@PathVariable int id){
        registrationGroupService.deleteRegistrationGroup(id);
    }

    //=============================endCrud==========================//

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
