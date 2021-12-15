package miu.edu.cs.cs544.CourseRegistrationSystem.service;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.AcademicBlock;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.AcademicBlockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAcademicBlockService {

    public List<AcademicBlock> findAll() ;

    public AcademicBlock getOne(int id);

    public AcademicBlock addBlock(AcademicBlock block);

    public AcademicBlock updateBlock(Integer blockId,AcademicBlock block) ;

    public void deleteBlock(Integer courseId);
}
