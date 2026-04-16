import java.sql.*;

/**
 * Database Connection Handler
 * This class manages the MySQL database connection for student data operations
 */
public class dbConnect {
    
    // Static connection reference (shared across instances)
    private static Connection mycon = null;

    /**
     * Establishes and returns a connection to the MySQL database
     * 
     * @return Connection object for database operations
     * @throws ClassNotFoundException if MySQL JDBC driver is not found
     * @throws SQLException if database connection fails
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        
        // Database configuration parameters
        String db   = "student_data";           // Database name
        String user = "root";              // Database username
        String pass = "";              // Database password
        
        // JDBC connection URL construction
        String url = "jdbc:mysql://host.docker.internal:3306/" + db;
        // String url = "jdbc:mysql://localhost:3306/" + db;
        
        // Load MySQL JDBC driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Establish and return the database connection
        Connection conn = DriverManager.getConnection(url, user, pass);
        
        return conn;
    }
}