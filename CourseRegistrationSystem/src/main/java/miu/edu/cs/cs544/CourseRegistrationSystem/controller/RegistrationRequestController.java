package miu.edu.cs.cs544.CourseRegistrationSystem.controller;


import miu.edu.cs.cs544.CourseRegistrationSystem.Model.CourseOffering;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.Registration;
import miu.edu.cs.cs544.CourseRegistrationSystem.Model.RegistrationRequest;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.CourseOfferingService;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.RegistrationRequestService;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/registrationrequest")
public class RegistrationRequestController {
    @Autowired
    private RegistrationRequestService registrationRequestService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private CourseOfferingService courseOfferingService;

    @PostMapping
    public ResponseEntity<RegistrationRequest> addRegistrationRequest(@RequestBody  RegistrationRequest registrationRequest){
        RegistrationRequest addedRegistrationRequest= registrationRequestService.add(registrationRequest);
        return new ResponseEntity<RegistrationRequest>( HttpStatus.OK);
    }
    @GetMapping
    public List<RegistrationRequest> listAllRegistrationRequest() {
        return registrationRequestService.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistrationRequest(@PathVariable int id,@RequestParam Action action) {
        RegistrationRequest registrationRequest =registrationRequestService.findRegistrationRequest(id);
        if(action.equals(Action.rejected)) {
            registrationRequestService.deleteRegistrationRequest(registrationRequest);
            return new ResponseEntity<Registration>(HttpStatus.OK);
        }
        ResponseEntity<Registration> registrationResponseEntity=null;
        CourseOffering courseOffering=courseOfferingService.findById(registrationRequest.getCourseOffering().getId()).get();
        if(courseOffering.getCapacity()-courseOffering.getNbOfRegisteredStudent()>0){
            courseOffering.setNbOfRegisteredStudent(courseOffering.getNbOfRegisteredStudent()+1);
            Registration registration =new Registration(registrationRequest.getCourseCode(),registrationRequest.getPriority(),
                    registrationRequest.getStudent(),registrationRequest.getCourseOffering());
            Registration addedRegistration= registrationService.add(registration);
            registrationResponseEntity=new ResponseEntity<Registration>(HttpStatus.OK);
            registrationRequestService.deleteRegistrationRequest(registrationRequest);

        }
        else{
            registrationResponseEntity=new ResponseEntity<Registration>(HttpStatus.BAD_REQUEST);
            registrationRequestService.deleteRegistrationRequest(registrationRequest);
        }
        return registrationResponseEntity;
    }
}
enum Action{
    rejected,
    approved
}
