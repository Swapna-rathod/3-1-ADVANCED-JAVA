import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
private static final String USER = "root";
private static final String PASSWORD = "1234";
public static Connection getConnection() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

        System.out.println("Database Connected Successfully!");

        return con;

    } catch (ClassNotFoundException | SQLException e) {

        System.out.println("Connection Failed!");

        e.printStackTrace();

        return null;
    }
}
}