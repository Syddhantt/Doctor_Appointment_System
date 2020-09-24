# Doctor_Appointment_System

# Built a web back-end API's for Doctor Appointment system that supports the following : 
* Get a list of all doctors
* Get a list of all appointments for a particular doctor and particular day
* Delete an existing appointment from a doctor's calendar
* Add a new appointment to a doctor's calendar
    * New appointments can only start at 15 minute intervals (ie, 8:15AM is valid but 8:20AM is not)
    * A doctor can have multiple appointments with the same time, but no more than 3 appointments
      can be added with the same time for a given doctor
      
# Doctors have a unique ID, a first name, and a last name. 

# Appointments have a unique ID,patient first name, patient last name, date & time, and kind (New Patient or Follow-up). 

# The backend responds to HTTP requests (ie GET, POST, DELETE).
