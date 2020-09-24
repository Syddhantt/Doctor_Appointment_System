package model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue
    private long appointmentId;

    private long doctorId;
    private String patientFirstName;
    private String patientLastName;
    private LocalDateTime dateTime;
    private String patientKind;
}
