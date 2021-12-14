package miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Student;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.StudentRepository;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
 private StudentRepository studentRepository;

 @Autowired
 public StudentServiceImpl(StudentRepository studentRepository){
     this.studentRepository=studentRepository;
  }

    @Override
    public void addStudent(Student student) {
     studentRepository.save(student);

    }

    @Override
    public void removeStudent(Integer Id) {
      studentRepository.deleteById(Id);
    }


    public Student getStudentById(Integer studentId) {
        Optional<Student> student=studentRepository.findById(studentId);
        if(student.isPresent()){
            return  student.orElse(null);
        }
return null;
    }


    public List<Student> getAllstudents()
    {
        return (List<Student>) studentRepository.findAll();
    }

}
