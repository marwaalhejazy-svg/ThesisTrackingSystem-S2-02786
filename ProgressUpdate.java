package thesis.system;

import java.util.Date;

/**
 * Class representing a thesis progress update.
 * @author Marwa Mousa
 */
public class ProgressUpdate {
    private String updateId;
    private Date updateDate;
    private String description;
    private String documentPath;
    private String milestone;
    
    public ProgressUpdate(String updateId, Date updateDate, String description) {
        this.updateId = updateId;
        this.updateDate = updateDate;
        this.description = description;
    }
    
    // Getters and Setters
    public String getUpdateId() { return updateId; }
    
    public Date getUpdateDate() { return updateDate; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        this.description = description;
    }
    
    public String getDocumentPath() { return documentPath; }
    public void setDocumentPath(String documentPath) { this.documentPath = documentPath; }
    
    public String getMilestone() { return milestone; }
    public void setMilestone(String milestone) { this.milestone = milestone; }
}