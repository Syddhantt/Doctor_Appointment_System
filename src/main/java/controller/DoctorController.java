package controller;

import java.util.List;
import model.Doctor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.DoctorService;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(final DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/allDoctors")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
}
