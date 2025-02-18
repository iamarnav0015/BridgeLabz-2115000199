import java.util.ArrayList;
import java.util.List;
// Abstract class representing a Job Role
abstract class JobRole {
    private String roleName;
    public JobRole(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleName() {
        return roleName;
    }
}
// Specific job roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

// Generic Resume class with bounded type parameter
class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    @Override
    public String toString() {
        return "Resume: " + candidateName + " (Role: " +
                jobRole.getRoleName() + ")";
    }
}

// Utility class for resume screening


class ResumeScreeningUtils {
    public static void processResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            System.out.println("Processing resume for: " +
                    resume.getRoleName());
        }
    }
}

// Resume Screening System
class ResumeScreeningSystem {
    private List<Resume<?>> resumePool = new ArrayList<>();

    public void addResume(Resume<?> resume) {
        resumePool.add(resume);
    }

    public void displayResumes() {
        for (Resume<?> resume : resumePool) {
            System.out.println(resume);
        }
    }
}

public class AIDrivenResumeScreening {
    public static void main(String[] args) {
        ResumeScreeningSystem system = new ResumeScreeningSystem();

        Resume<SoftwareEngineer> seResume = new Resume<>("Alice", new
                SoftwareEngineer());
        Resume<DataScientist> dsResume = new Resume<>("Bob", new
                DataScientist());
        Resume<ProductManager> pmResume = new Resume<>("Charlie", new
                ProductManager());

        system.addResume(seResume);
        system.addResume(dsResume);
        system.addResume(pmResume);

        System.out.println("AI-Driven Resume Screening System:");
        system.displayResumes();
    }
}