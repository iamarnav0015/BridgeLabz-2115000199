class Patient {
    private static String hospitalName = "City General Hospital";
    private static int totalPatients = 0;

    private String name;
    private int age;
    private String ailment;
    private final int patientID;

    private static int patientCounter = 0;
    public Patient(String name, int age, String ailment) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = ++patientCounter;
        totalPatients++;
        System.out.println("Patient Admitted: " + name + " (Patient ID: " + patientID + ", Age: " + age + ", Ailment: " + ailment + ")");
    }
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }
    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Patient Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Hospital Name: " + hospitalName);
        } else {
            System.out.println("Invalid patient object.");
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient.getTotalPatients();

        Patient patient1 = new Patient("John Doe", 45, "Flu");
        Patient patient2 = new Patient("Jane Smith", 32, "Fracture");
        patient1.displayPatientDetails();
        patient2.displayPatientDetails();
        Patient.getTotalPatients();
    }
}
