package thesis.system;
/**
 * Class representing a program coordinator.
 */
public class ProgramCoordinator extends Person {
    private String coordinatorId;
    private String programName;
    
    public ProgramCoordinator(String id, String name, String email, String password,
                             String coordinatorId, String programName) {
        super(id, name, email, password);
        this.coordinatorId = coordinatorId;
        this.programName = programName;
    }
    
    @Override
    public String getRole() {
        return "Program Coordinator";
    }
    
    public String getCoordinatorId() { return coordinatorId; }
    public String getProgramName() { return programName; }
    
    /**
     * Monitors overall program status.
     */
    public void generateReport() {
        System.out.println("Generating report for program: " + programName);
    }
}