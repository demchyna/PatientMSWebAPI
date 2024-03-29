package demchyna.patientms.controller;

import demchyna.patientms.auditor.AuditLogger;
import demchyna.patientms.model.Patient;
import demchyna.patientms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @AuditLogger
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient create(@RequestBody Patient patient) {
        return patientService.create(patient);
    }

    @AuditLogger
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Patient readById(@PathVariable long id) {
        return patientService.readById(id);
    }

    @AuditLogger
    @PutMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public Patient update(@RequestBody Patient patient) {
        return patientService.update(patient);
    }

    @AuditLogger
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        patientService.delete(id);
    }

    @AuditLogger
    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Patient> readAll() {
        return patientService.getAll();
    }
}
