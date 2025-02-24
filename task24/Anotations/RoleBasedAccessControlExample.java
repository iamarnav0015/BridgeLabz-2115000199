
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

class AccessControl {
    private String currentUserRole;

    public AccessControl(String role) {
        this.currentUserRole = role;
    }

    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed successfully.");
    }

    public void executeTask(String methodName) {
        try {
            Method method = this.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                String requiredRole = method.getAnnotation(RoleAllowed.class).value();
                if (!currentUserRole.equals(requiredRole)) {
                    System.out.println("Access Denied! " + currentUserRole + " role is not authorized.");
                    return;
                }
            }
            method.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class RoleBasedAccessControlExample {
    public static void main(String[] args) {
        AccessControl adminUser = new AccessControl("ADMIN");
        adminUser.executeTask("adminTask"); // Should execute successfully

        AccessControl regularUser = new AccessControl("USER");
        regularUser.executeTask("adminTask"); // Should print "Access Denied!"
    }
}

