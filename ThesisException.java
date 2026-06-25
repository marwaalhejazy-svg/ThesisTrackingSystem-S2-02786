 package thesis.system;

/**
 * Custom exception class for Thesis Tracking System errors.
 * Demonstrates Exception Handling and Inheritance.
 * @author Marwa Mousa
 */
public class ThesisException extends Exception {
    
	private static final long serialVersionUID = 1L;

	// Constructor that accepts a custom error message
    public ThesisException(String message) {
        super(message);
    }
}