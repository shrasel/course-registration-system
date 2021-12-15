package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.AcademicBlock;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.Impl.AcademicBlockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/AcademicBlock")
public class AcademicBlockController {
    @Autowired
    AcademicBlockServiceImpl academicBlockService;

    @GetMapping
    public List<AcademicBlock> getAcademicBlock(){
        return academicBlockService.findAll();
    }
    @GetMapping(value = {"id"})
    public AcademicBlock getAcademicBlockById(@PathVariable int id){
        return academicBlockService.getOne(id);
    }
   @PostMapping
    public AcademicBlock CreateAcademicBlock(@RequestBody AcademicBlock block){
        return  academicBlockService.addBlock(block);
    }
    @PutMapping(value = {"id"})
    public AcademicBlock updateBlock(@PathVariable Integer blockId,@RequestBody AcademicBlock block) {
        return academicBlockService.updateBlock(blockId,block);
    }
   @DeleteMapping(value = {"id"})
    public void deleteBlock(@PathVariable Integer courseId){
        academicBlockService.deleteBlock(courseId);
    }
}
