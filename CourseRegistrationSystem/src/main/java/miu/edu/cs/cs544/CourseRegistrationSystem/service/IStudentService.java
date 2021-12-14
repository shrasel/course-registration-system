package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {
    public void addStudent(Student student);
    public void removeStudent(Integer Id);
    public Student getStudentById(Integer studentId) ;
    public List<Student> getAllstudents();

}
