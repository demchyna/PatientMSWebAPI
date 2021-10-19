package demchyna.patientms.service;

import demchyna.patientms.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    Patient create(Patient patient);
    Patient readById(long id);
    Patient update(Patient patient);
    void delete(long id);

    List<Patient> getAll();
}
