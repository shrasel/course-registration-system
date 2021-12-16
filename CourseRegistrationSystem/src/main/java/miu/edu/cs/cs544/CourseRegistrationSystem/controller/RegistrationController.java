package miu.edu.cs.cs544.CourseRegistrationSystem.controller;

import miu.edu.cs.cs544.CourseRegistrationSystem.model.Registration;
import miu.edu.cs.cs544.CourseRegistrationSystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public Registration createRegistration(@RequestBody Registration registration) {
        return registrationService.create(registration);

    }
    @PutMapping("/{registrationId}")
    public ResponseEntity<?> updateRegistration(@PathVariable int registrationId, @RequestBody Registration registration) {
        if (registrationId==registration.getId()) {
            return ResponseEntity.ok(registrationService.update(registrationId, registration));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public String listRegistrations(Model model) {
        model.addAttribute("registration", registrationService.findAll());
        return "registration";
    }
    @GetMapping("/delete")
    public String deleteRegistration(Model model, @PathVariable("registration") int registrationId) {
        registrationService.deleteRegistration(registrationId);
        return listRegistrations(model);
    }
}
