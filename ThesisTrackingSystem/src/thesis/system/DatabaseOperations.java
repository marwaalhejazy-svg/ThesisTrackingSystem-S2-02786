package thesis.system;

import java.sql.SQLException;

/**
 * Interface defining the contract for database operations.
 * @author Marwa Mousa
 */
public interface DatabaseOperations {
    
    /**
     * Establishes a connection to the database.
     * @throws SQLException if a database access error occurs
     */
    void connect() throws SQLException;
    
    /**
     * Closes the database connection.
     * @throws SQLException if a database access error occurs
     */
    void disconnect() throws SQLException;
    
    /**
     * Checks if the database is currently connected.
     * @return true if connected, false otherwise
     */
    boolean isConnected();
}