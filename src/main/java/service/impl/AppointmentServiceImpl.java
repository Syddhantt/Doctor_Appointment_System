package service.impl;

import exception.InvalidAppointmentException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import model.Appointment;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AppointmentRepository;
import service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentServiceImpl(final AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getDoctorAppointments(long uniqueId, LocalDate day) {
        List<Appointment> appointmentList = appointmentRepository.findAll();
        return appointmentList.stream()
                .filter(appointment -> appointment.getDoctorId() == uniqueId)
                .filter(appointment -> appointment.getDateTime().toLocalDate().equals(day))
                .collect(Collectors.toList());
    }

    @Override
    public void addNewAppointment(Appointment appointment) throws InvalidAppointmentException {
        if (appointment.getDateTime().toLocalTime().getMinute() % 15 == 0) {
            if (appointmentRepository.findAll().stream()
                    .filter(i -> i.getDoctorId() == appointment.getDoctorId())
                    .filter(i -> i.getDateTime().toLocalTime().equals(appointment.getDateTime().toLocalTime()))
                    .count() < 3) {
                appointmentRepository.save(appointment);
            }  else {
                throw new InvalidAppointmentException("Doctor can't have more than 3 appointments at the same time");
            }
        }
        else {
            throw new InvalidAppointmentException("Invalid time, appointment can only start at 15 minute interval");
        }
    }

    @Override
    public void deleteAppointment(long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
