import java.util.*;

// Abstract Patient Class
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// MedicalRecord Interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// InPatient Class
class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int stayDuration;
    private List<String> medicalRecords;

    public InPatient(String patientId, String name, int age, double dailyRate, int stayDuration) {
        super(patientId, name, age);
        this.dailyRate = dailyRate;
        this.stayDuration = stayDuration;
        this.medicalRecords = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return dailyRate * stayDuration;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for In-Patient:");
        for (String record : medicalRecords) {
            System.out.println(record);
        }
    }
}

// OutPatient Class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalRecords;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalRecords = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for Out-Patient:");
        for (String record : medicalRecords) {
            System.out.println(record);
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient inPatient = new InPatient("P001", "Alice Smith", 45, 200.0, 5);
        inPatient.addRecord("Admitted for surgery.");
        inPatient.addRecord("Underwent successful operation.");
        patients.add(inPatient);

        OutPatient outPatient = new OutPatient("P002", "Bob Johnson", 32, 100.0);
        outPatient.addRecord("Consulted for back pain.");
        patients.add(outPatient);

        // Process and display patient details
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Bill Amount: $" + patient.calculateBill());
            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).viewRecords();
            }
            System.out.println("---------------------------");
        }
    }
}
