import java.util.ArrayList;

// Hospital class that contains Doctor and Patient classes
class Hospital {
    String name;
    ArrayList<Doctor> doctors;
    ArrayList<Patient> patients;

    Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Add a doctor to the hospital
    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Add a patient to the hospital
    void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Display doctors in the hospital
    void displayDoctors() {
        System.out.println("Doctors in " + name + ":");
        for (Doctor d : doctors) {
            System.out.println(d.name);
        }
    }

    // Display patients in the hospital
    void displayPatients() {
        System.out.println("Patients in " + name + ":");
        for (Patient p : patients) {
            System.out.println(p.name);
        }
    }
}

// Doctor class representing a doctor who can consult multiple patients
class Doctor {
    String name;
    ArrayList<Patient> patients; // Association: Doctor consults multiple Patients

    Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    // Method to consult a patient (Association with Patient)
    void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
        patient.addDoctor(this);
        System.out.println("Dr. " + name + " is consulting patient " + patient.name);
    }

    // View patients consulted by the doctor
    void viewPatients() {
        System.out.println("Patients consulted by Dr. " + name + ":");
        for (Patient p : patients) {
            System.out.println(p.name);
        }
    }
}

// Patient class representing a patient who can consult multiple doctors
class Patient {
    String name;
    ArrayList<Doctor> doctors; // Association: Patient consults multiple Doctors

    Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    // Method to add a doctor to the patient's consultation list
    void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    // View doctors consulted by the patient
    void viewDoctors() {
        System.out.println("Doctors consulted by " + name + ":");
        for (Doctor d : doctors) {
            System.out.println("Dr. " + d.name);
        }
    }
}

// Main class to demonstrate the association and communication relationships
public class HospitalAssociation {
    public static void main(String[] args) {
        // Create a Hospital
        Hospital hospital = new Hospital("Apollo Hospital");

        // Create Doctors with Indian names
        Doctor drSharma = new Doctor("Ramesh Sharma");
        Doctor drIyer = new Doctor("Suresh Iyer");

        // Create Patients with Indian names
        Patient ananya = new Patient("Ananya Verma");
        Patient raj = new Patient("Raj Gupta");

        // Add Doctors and Patients to the Hospital
        hospital.addDoctor(drSharma);
        hospital.addDoctor(drIyer);
        hospital.addPatient(ananya);
        hospital.addPatient(raj);

        // Consultations (Association between Doctor and Patient)
        drSharma.consult(ananya);
        drSharma.consult(raj);
        drIyer.consult(ananya);

        // View consultations
        drSharma.viewPatients();
        drIyer.viewPatients();
        ananya.viewDoctors();
        raj.viewDoctors();
    }
}
