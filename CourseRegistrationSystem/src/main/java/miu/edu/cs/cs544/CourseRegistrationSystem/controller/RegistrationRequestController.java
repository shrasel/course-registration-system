package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import miu.edu.cs.cs544.CourseRegistrationSystem.Model.RegistrationRequest;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registrationrequest")
public class RegistrationRequestController {
    @Autowired
    private RegistrationRequestService registrationRequestService;

    @PostMapping
    public RegistrationRequest createRegistrationRequest(@RequestBody RegistrationRequest registrationRequest) {
        return registrationRequestService.create(registrationRequest);

    }
    @PutMapping("/{registrationRequestId}")
    public ResponseEntity<?> updateRegistrationRequest(@PathVariable int registrationRequestId, @RequestBody RegistrationRequest registrationRequest) {
        if (registrationRequestId==registrationRequest.getId()) {
            return ResponseEntity.ok(registrationRequestService.update(registrationRequestId, registrationRequest));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public String listRegistrationsRequest(Model model) {
        model.addAttribute("registrationRequest", registrationRequestService.findAll());
        return "registrationRequest";
    }
    @GetMapping("/delete")
    public String deleteRegistrationRequest(Model model, @PathVariable("registrationRequest") int registrationRequestId) {
        registrationRequestService.deleteRegistrationRequest(registrationRequestId);
        return listRegistrationsRequest(model);
    }
}
