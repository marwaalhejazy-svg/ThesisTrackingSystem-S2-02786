package thesis.system;
/**
 * Abstract class representing a person in the system.
 * Serves as the base class for all user types.
 * @author Marwa Mousa
 * @version 1.0
 */
public abstract class Person {
    private String id;
    private String name;
    private String email;
    private String password;
    
    /**
     * Constructor for Person class.
     * @param id The unique identifier
     * @param name The full name
     * @param email The email address
     * @param password The account password
     */
    public Person(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    // Encapsulation - Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    // Abstract method - Polymorphism
    public abstract String getRole();
    
    /**
     * Displays person information.
     */
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Role: " + getRole());
    }
}