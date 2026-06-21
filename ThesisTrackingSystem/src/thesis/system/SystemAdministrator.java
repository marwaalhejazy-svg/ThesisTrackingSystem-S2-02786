package thesis.system;

/**
 * Class representing a system administrator.
 * @author Marwa Mousa
 */
public class SystemAdministrator extends Person {
    private String adminId;
    
    public SystemAdministrator(String id, String name, String email, String password,
                              String adminId) {
        super(id, name, email, password);
        this.adminId = adminId;
    }
    
    @Override
    public String getRole() {
        return "System Administrator";
    }
    
    public String getAdminId() { return adminId; }
    
    public void createUserAccount(Person user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        System.out.println("Creating account for: " + user.getName());
    }
    
    public void resetPassword(Person user, String newPassword) {
        if (user == null || newPassword == null) {
            throw new IllegalArgumentException("User and password cannot be null");
        }
        user.setPassword(newPassword);
        System.out.println("Password reset for: " + user.getName());
    }
}