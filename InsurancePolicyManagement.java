import java.util.*;

class InsurancePolicy {
    String policyNumber;
    String policyholderName;
    Date expiryDate;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyholderName + ", Expiry: " + expiryDate;
    }
}

public class InsurancePolicyManagement {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private LinkedHashMap<String, InsurancePolicy> orderedPolicies = new LinkedHashMap<>();
    private TreeMap<Date, InsurancePolicy> sortedPolicies = new TreeMap<>();

    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicies.put(policy.policyNumber, policy);
        sortedPolicies.put(policy.expiryDate, policy);
    }

    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<InsurancePolicy> getPoliciesExpiringSoon(int days) {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        Date now = new Date();
        Date threshold = new Date(now.getTime() + (long) days * 24 * 60 * 60 * 1000);
        for (Map.Entry<Date, InsurancePolicy> entry : sortedPolicies.entrySet()) {
            if (entry.getKey().before(threshold)) {
                expiringPolicies.add(entry.getValue());
            } else {
                break;
            }
        }
        return expiringPolicies;
    }

    public List<InsurancePolicy> getPoliciesByHolder(String holderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.policyholderName.equals(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        Date now = new Date();
        Iterator<Map.Entry<Date, InsurancePolicy>> iterator = sortedPolicies.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Date, InsurancePolicy> entry = iterator.next();
            if (entry.getKey().before(now)) {
                policyMap.remove(entry.getValue().policyNumber);
                orderedPolicies.remove(entry.getValue().policyNumber);
                iterator.remove();
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        system.addPolicy(new InsurancePolicy("P001", "Rajesh Kumar", new Date(System.currentTimeMillis() + 86400000L * 10)));
        system.addPolicy(new InsurancePolicy("P002", "Priya Sharma", new Date(System.currentTimeMillis() + 86400000L * 5)));
        system.addPolicy(new InsurancePolicy("P003", "Rajesh Kumar", new Date(System.currentTimeMillis() - 86400000L)));

        System.out.println("Policy by Number: " + system.getPolicyByNumber("P001"));
        System.out.println("Policies Expiring Soon: " + system.getPoliciesExpiringSoon(30));
        System.out.println("Policies by Holder (Rajesh Kumar): " + system.getPoliciesByHolder("Rajesh Kumar"));
        system.removeExpiredPolicies();
        System.out.println("Policies after removing expired: " + system.policyMap.values());
    }
}
