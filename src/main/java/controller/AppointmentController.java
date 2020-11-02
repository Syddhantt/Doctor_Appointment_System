package controller;

import exception.InvalidAppointmentException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AppointmentService;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(final AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{doctorId}/{day}")
    public List<Appointment> getDoctorAppointments(@PathVariable("doctorId") long uniqueId,
                                                   @PathVariable("day") LocalDate day) {
        return appointmentService.getDoctorAppointments(uniqueId, day);
    }

    @PostMapping("/addAppointment")
    public String addNewDoctorAppointment(@RequestBody Appointment appointment) {
        try {
            appointmentService.addNewAppointment(appointment);
            return "New Appointment Added Successfully";
        } catch (InvalidAppointmentException e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("/delete/{appointmentId}")
    public void deleteAppointment(@PathVariable("appointmentId") long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
    }

}
