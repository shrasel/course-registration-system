package miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl;

import miu.edu.cs.cs544.CourseRegistrationSystem.DTO.StudentDTO;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.AcadamicBlock;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.RegistrationGroup;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.RegistrationGroupStudents;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Student;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.RegistrationGroupRepo;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.RegistrationGroupStudentRepo;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.StudentRepository;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.IRegistrationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RegistrationGroupServiceImpl implements IRegistrationGroupService {
    private RegistrationGroupRepo registrationGroupRepo;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RegistrationGroupStudentRepo registrationGroupStudentRepo;

    @Autowired
    public RegistrationGroupServiceImpl(RegistrationGroupRepo registrationGroupRepo) {
        this.registrationGroupRepo = registrationGroupRepo;
    }

    @Override
    public void addStudent(StudentDTO studentDto) {
        Student student = studentRepository.findByStudentId(studentDto.getStudentId());
        Optional<RegistrationGroup> registrationGroup = registrationGroupRepo.findById(studentDto.getGroupId());
        RegistrationGroupStudents registrationGroupStudent = new RegistrationGroupStudents();
        registrationGroupStudent.setStudent_id(student.getId());
        registrationGroupStudent.setRegroupid(registrationGroup.get().getId());
        registrationGroupStudentRepo.save(registrationGroupStudent);

    }

    private Student convertStudentModel(StudentDTO studentDto){
        Student student = new Student();
        student.setStudentId(studentDto.getStudentId());
        student.setEmail(studentDto.getEmail());
        student.setHomeAddress(studentDto.getHomeAddress());
        student.setMailingAddress(studentDto.getMailingAddress());
        student.setName(studentDto.getName());
        return student;
    }


    @Override
    public void addBlock(int groupId, AcadamicBlock block) {
        Optional<RegistrationGroup> registrationGroup = registrationGroupRepo.findById(groupId);
        registrationGroup.ifPresentOrElse(r-> {
            r.getAcadamicBlockList().stream().filter(b -> b.getId() == block.getId()).findAny().orElseThrow(() -> new IllegalArgumentException("This block is already exist"));
            r.addBlock(block);
        },()->{
        new IllegalArgumentException("This Group is not exist");
    });

}

    @Override

    public void removeStudent(int groupId, int studentId) {

        Optional<RegistrationGroup> registrationGroup = registrationGroupRepo.findById(groupId);
        registrationGroup.ifPresentOrElse(r-> {
           // Optional<Student> student = r.getStudents().stream().filter(s -> s.getId() == studentId).findAny();
           // student.ifPresentOrElse(s -> {
                r.removeStudent(groupId,studentId);

            }, () -> {
                new IllegalArgumentException("The student is not exist in this Group");
            });
      // }, () -> {
            new IllegalArgumentException("This Group is not exist");

       // });

    }


    @Override
    public void removeBlock(int groupId, AcadamicBlock block) {
        Optional<RegistrationGroup> registrationGroup = registrationGroupRepo.findById(groupId);
        registrationGroup.ifPresentOrElse(r -> {
            Optional<AcadamicBlock> acadamicBlock = r.getAcadamicBlockList().stream().filter(b -> b.getId() == block.getId()).findAny();
            acadamicBlock.ifPresentOrElse(ab -> {
                r.removeBlock(groupId, block);
            }, () -> {
                new IllegalArgumentException("The block doesn't exist in this group");
            });
        }, () -> {
            new IllegalArgumentException("This group doesn't exist");

        });
    }

}
