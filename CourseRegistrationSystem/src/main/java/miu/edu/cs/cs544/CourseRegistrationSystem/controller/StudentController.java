package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Student;

import miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;

    @PostMapping()
    public void createStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getStudent(){
        return studentService.getAllstudents();
    }
@GetMapping("/update/{id}")
public Student getStudentById(@PathVariable int id){
        return  studentService.getStudentById(id);
}
    @DeleteMapping(value = "{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.removeStudent(id);
    }

}
