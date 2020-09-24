package service;

import exception.InvalidAppointmentException;
import java.time.LocalDate;
import java.util.List;
import model.Appointment;

public interface AppointmentService {

    List<Appointment> getDoctorAppointments(long uniqueId, LocalDate day);

    void addNewAppointment(Appointment appointment) throws InvalidAppointmentException;

    void deleteAppointment(long appointmentId);
}
