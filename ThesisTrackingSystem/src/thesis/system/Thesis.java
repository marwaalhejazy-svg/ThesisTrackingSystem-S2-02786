package thesis.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class representing a thesis.
 * @author Marwa Mousa
 */
public class Thesis {
    private String thesisId;
    private String title;
    private String field;
    private Date startDate;
    private String status;
    private Student student;
    private Supervisor supervisor;
    private List<ProgressUpdate> progressUpdates;
    
    public Thesis(String thesisId, String title, String field, Date startDate) {
        this.thesisId = thesisId;
        this.title = title;
        this.field = field;
        this.startDate = startDate;
        this.status = "In Progress";
        this.progressUpdates = new ArrayList<>();
    }
    
    // Getters and Setters
    public String getThesisId() { return thesisId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getField() { return field; }
    
    public Date getStartDate() {  return startDate;  }
    
    public void setStartDate(Date startDate) { 
        this.startDate = startDate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    
    public Supervisor getSupervisor() { return supervisor; }
    public void setSupervisor(Supervisor supervisor) { this.supervisor = supervisor; }
    
    public void addProgressUpdate(ProgressUpdate update) {
        progressUpdates.add(update);
    }
    
    public List<ProgressUpdate> getProgressUpdates() {
        return new ArrayList<>(progressUpdates);
    }
}