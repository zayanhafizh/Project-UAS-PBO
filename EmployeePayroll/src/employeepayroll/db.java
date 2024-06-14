package employeepayroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Database connection class for Employee Payroll system.
 */
public class db {

    /**
     * Establishes and returns a connection to the SQLite database.
     * 
     * @return Connection object or null if connection fails
     */
    public static Connection java_db() {
        Connection conn = null;
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Establish the connection using the correct SQLite database URL
            String dbPath = "D:\\Semester 4\\PBO\\ProjectUAS\\EmployeePayroll\\PaymentPayroll.sqlite";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);

            return conn;
        } catch (ClassNotFoundException e) {
            // Handle the case where the JDBC driver is not found
            JOptionPane.showMessageDialog(null, "SQLite JDBC driver not found: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            // Handle SQL-related errors
            JOptionPane.showMessageDialog(null, "Database connection error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Closes the provided database connection.
     * 
     * @param conn Connection object to be closed
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Failed to close database connection: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
}
