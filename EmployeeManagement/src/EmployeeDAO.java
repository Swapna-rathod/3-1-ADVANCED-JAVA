import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    // Insert Employee
    public void insertEmployee(Employee emp) {

        Connection con = DBConnection.getConnection();

        try {

            String sql = "INSERT INTO employee VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setDouble(3, emp.getSalary());
            ps.setString(4, emp.getDepartment());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee inserted successfully.");
            } else {
                System.out.println("Failed to insert employee.");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Display Employees
    public void displayEmployees() {

        Connection con = DBConnection.getConnection();

        try {

            String sql = "SELECT * FROM employee";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n-----------------------------------------------");
            System.out.println("ID\tName\tSalary\tDepartment");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + "\t"
                                + rs.getString("name") + "\t"
                                + rs.getDouble("salary") + "\t"
                                + rs.getString("department"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Employee Salary
    public void updateEmployeeSalary(int id, double salary) {

        Connection con = DBConnection.getConnection();

        try {

            String sql = "UPDATE employee SET salary = ? WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Salary updated successfully.");
            } else {
                System.out.println("Employee not found.");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {

        Connection con = DBConnection.getConnection();

        try {

            String sql = "DELETE FROM employee WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee not found.");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}