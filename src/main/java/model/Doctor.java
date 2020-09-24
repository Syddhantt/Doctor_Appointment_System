package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Doctor {
    
    @Id
    @GeneratedValue
    private long doctorId;
    
    private String firstName;
    private String lastName;
}
