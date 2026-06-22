package thesis.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class handling database connections, implementing DatabaseOperations interface.
 * @author Marwa Mousa
 */
public class DatabaseConnection implements DatabaseOperations {
    private Connection connection;
    private String url;
    private String username;
    private String password;
    private boolean connected;
    
    /**
     * Constructor for DatabaseConnection.
     * @param url The database URL
     * @param username The database username
     * @param password The database password
     */
    public DatabaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.connected = false;
    }
    
    @Override
    public void connect() throws SQLException {
        try {
            // Note: In a real scenario, you would load the driver here if needed
            // Class.forName("com.mysql.cj.jdbc.Driver"); 
            connection = DriverManager.getConnection(url, username, password);
            connected = true;
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            connected = false;
            throw e;
        }
    }
    
    @Override
    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connected = false;
            System.out.println("Database disconnected successfully!");
        }
    }
    
    @Override
    public boolean isConnected() {
        return connected;
    }
    
    /**
     * Returns the active connection object.
     * @return Connection object
     */
    public Connection getConnection() {
        return connection;
    }
}