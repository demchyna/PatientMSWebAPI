package demchyna.patientms.service.impl;

import demchyna.patientms.exception.NullReferenceEntityException;
import demchyna.patientms.model.Patient;
import demchyna.patientms.repository.PatientRepository;
import demchyna.patientms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient create(Patient patient) {
        if (patient != null) {
            return patientRepository.save(patient);
        }
        throw new NullReferenceEntityException("The patient cannot be 'null'");
    }

    @Override
    public Patient readById(long id) {
        return patientRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("The patient with id " + id + " not found"));
    }

    @Override
    public Patient update(Patient patient) {
        if (patient != null) {
            readById(patient.getId());
            return patientRepository.save(patient);
        }
        throw new NullReferenceEntityException("The patient cannot be 'null'");
    }

    @Override
    public void delete(long id) {
        Patient patient = readById(id);
        patientRepository.delete(patient);
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }
}
