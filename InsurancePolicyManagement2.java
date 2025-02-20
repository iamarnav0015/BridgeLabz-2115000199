import java.util.*;

class InsurancePolicy2 implements Comparable<InsurancePolicy2> {
    String policyNumber;
    String policyholderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

    public InsurancePolicy2(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public int compareTo(InsurancePolicy2 other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy2 policy = (InsurancePolicy2) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyholderName + ", Expiry: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagement2 {
    private Set<InsurancePolicy2> policySet = new HashSet<>();
    private LinkedHashSet<InsurancePolicy2> orderedPolicies = new LinkedHashSet<>();
    private TreeSet<InsurancePolicy2> sortedPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy2 policy) {
        policySet.add(policy);
        orderedPolicies.add(policy);
        sortedPolicies.add(policy);
    }

    public List<InsurancePolicy2> getPoliciesExpiringSoon(int days) {
        List<InsurancePolicy2> expiringPolicies = new ArrayList<>();
        Date now = new Date();
        Date threshold = new Date(now.getTime() + (long) days * 24 * 60 * 60 * 1000);
        for (InsurancePolicy2 policy : sortedPolicies) {
            if (policy.expiryDate.before(threshold)) {
                expiringPolicies.add(policy);
            } else {
                break;
            }
        }
        return expiringPolicies;
    }

    public List<InsurancePolicy2> getPoliciesByCoverage(String coverageType) {
        List<InsurancePolicy2> policies = new ArrayList<>();
        for (InsurancePolicy2 policy : policySet) {
            if (policy.coverageType.equalsIgnoreCase(coverageType)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public Set<InsurancePolicy2> getAllUniquePolicies() {
        return policySet;
    }

    public void displayPerformanceComparison() {
        System.out.println("Performance Comparison: HashSet, LinkedHashSet, TreeSet");
    }

    public static void main(String[] args) {
        InsurancePolicyManagement2 system = new InsurancePolicyManagement2();
        system.addPolicy(new InsurancePolicy2("P001", "Rajesh Kumar", new Date(System.currentTimeMillis() + 86400000L * 10), "Health", 5000));
        system.addPolicy(new InsurancePolicy2("P002", "Priya Sharma", new Date(System.currentTimeMillis() + 86400000L * 5), "Auto", 3000));
        system.addPolicy(new InsurancePolicy2("P003", "Amit Verma", new Date(System.currentTimeMillis() - 86400000L), "Home", 7000));

        System.out.println("All Unique Policies: " + system.getAllUniquePolicies());
        System.out.println("Policies Expiring Soon: " + system.getPoliciesExpiringSoon(30));
        System.out.println("Auto Insurance Policies: " + system.getPoliciesByCoverage("Auto"));
        system.displayPerformanceComparison();
    }
}
