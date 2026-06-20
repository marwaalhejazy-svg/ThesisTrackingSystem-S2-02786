package thesis.system;
/**
 * Class representing a postgraduate student.
 * Extends Person class.
 */
public class Student extends Person {
    private String studentNumber;
    private String program;
    private Thesis currentThesis;
    
    /**
     * Constructor for Student.
     */
    public Student(String id, String name, String email, String password, 
                   String studentNumber, String program) {
        super(id, name, email, password);
        this.studentNumber = studentNumber;
        this.program = program;
    }
    
    @Override
    public String getRole() {
        return "Student";
    }
    
    // Getters and Setters
    public String getStudentNumber() { return studentNumber; }
    public void setStudentNumber(String studentNumber) { 
        this.studentNumber = studentNumber; 
    }
    
    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }
    
    public Thesis getCurrentThesis() { return currentThesis; }
    public void setCurrentThesis(Thesis thesis) { this.currentThesis = thesis; }
    
    /**
     * Updates thesis progress.
     * @param update The progress update
     * @throws IllegalArgumentException if update is null
     */
    public void updateThesisProgress(ProgressUpdate update) {
        if (update == null) {
            throw new IllegalArgumentException("Progress update cannot be null");
        }
        if (currentThesis != null) {
            currentThesis.addProgressUpdate(update);
            System.out.println("Progress updated successfully for thesis: " + 
                             currentThesis.getTitle());
        } else {
            throw new IllegalStateException("No thesis assigned to this student");
        }
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student Number: " + studentNumber);
        System.out.println("Program: " + program);
    }
}