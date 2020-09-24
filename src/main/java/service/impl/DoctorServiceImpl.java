package service.impl;

import java.util.List;
import model.Doctor;
import org.springframework.stereotype.Service;
import repository.DoctorRepository;
import service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(final DoctorRepository doctorRepository) {
        this.doctorRepository =  doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
