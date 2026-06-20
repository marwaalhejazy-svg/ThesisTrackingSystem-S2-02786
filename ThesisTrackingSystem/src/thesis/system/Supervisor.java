package thesis.system;

/**
 * Class representing a thesis supervisor.
 * @author Marwa Mousa
 */
public class Supervisor extends Person {
    private String employeeId;
    private String department;
    
    public Supervisor(String id, String name, String email, String password,
                     String employeeId, String department) {
        super(id, name, email, password);
        this.employeeId = employeeId;
        this.department = department;
    }
    
    @Override
    public String getRole() {
        return "Supervisor";
    }
    
    // Getters and Setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    /**
     * Reviews student progress and provides feedback.
     */
    public void reviewProgress(Student student, String feedback) {
        if (student == null || feedback == null) {
            throw new IllegalArgumentException("Student and feedback cannot be null");
        }
        System.out.println("Reviewing progress for student: " + student.getName());
        System.out.println("Feedback: " + feedback);
    }
}