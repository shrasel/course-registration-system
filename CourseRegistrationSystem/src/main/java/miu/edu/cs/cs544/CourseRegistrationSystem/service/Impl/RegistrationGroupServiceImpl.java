package miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.AcadamicBlock;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.RegistrationGroup;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Student;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.RegistrationGroupRepo;
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
    public RegistrationGroupServiceImpl(RegistrationGroupRepo registrationGroupRepo) {
        this.registrationGroupRepo = registrationGroupRepo;
    }

    @Override
    public void addStudent(int groupId, Student student) {
        Optional<RegistrationGroup> registrationGroup = registrationGroupRepo.findById(groupId);
        registrationGroup.ifPresentOrElse(r->{
            r.getStudents().stream().filter(s -> s.getId() ==student.getId() ).findAny().orElseThrow(()->new IllegalArgumentException("This Student is already exist"));
            r.addStudent(student);
        },()->{
            new IllegalArgumentException("This Group is not exist");
        });

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
            Optional<Student> student = r.getStudents().stream().filter(s -> s.getId() == studentId).findAny();
            student.ifPresentOrElse(s -> {
                r.removeStudent(groupId,studentId);

            }, () -> {
                new IllegalArgumentException("The student is not exist in this Group");
            });
        }, () -> {
            new IllegalArgumentException("This Group is not exist");

        });

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
