package miu.edu.cs.cs544.CourseRegistrationSystem.Impl;


import miu.edu.cs.cs544.CourseRegistrationSystem.model.AcademicBlock;
import miu.edu.cs.cs544.CourseRegistrationSystem.repository.AcademicBlockRepository;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.IAcademicBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AcademicBlockServiceImpl implements IAcademicBlockService {

    @Autowired
    private AcademicBlockRepository repository;

    public List<AcademicBlock> findAll() {
        return repository.findAll();
    }

    public AcademicBlock getOne(int id) {
        return (AcademicBlock) repository.getOne(id);
    }

    @Override
    public AcademicBlock addBlock(AcademicBlock block) {
        return null;
    }

    @Override
    public AcademicBlock updateBlock(Integer blockId, AcademicBlock block) {
        return null;
    }

    /*public AcademicBlock addBlock(AcademicBlock block) {

        return repository.save(block);
    }

    public AcademicBlock updateBlock(Integer blockId,AcademicBlock block) {
        AcademicBlock newblock = (AcademicBlock) repository.findById(blockId).orElse(null);
        block.setName(name);
        block.setLocalDate(code);
        return repository.save(newblock);
    }*/

    public void deleteBlock(Integer courseId) {
        repository.deleteById(courseId);
    }
}

