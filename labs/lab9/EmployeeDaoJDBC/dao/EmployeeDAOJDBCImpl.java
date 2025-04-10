package lab9.EmployeeDaoJDBC.dao;

import lab9.EmployeeDaoJDBC.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {
    private Connection con = null;

    EmployeeDAOJDBCImpl() {
        String url = "jdbc:postgresql://localhost:5432/employeedb";
        String user = "postgres";
        String password = "postgres";
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error obtaining connection with the database: " + e);
            System.exit(-1);
        }
    }
    @Override
    public void add(Employee emp) throws DAOException {
        String query = "INSERT INTO employee VALUES (?,?,?,?,?)";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, emp.getId());
            stmt.setString(2, emp.getFirstName());
            stmt.setString(3, emp.getLastName());
            java.sql.Date sqlDate = new java.sql.Date(emp.getBirthDate().getTime());
            stmt.setDate(4, sqlDate);
            stmt.setFloat(5, emp.getSalary());

            if (stmt.executeUpdate() != 1) { throw new DAOException("Error adding employee"); }
        } catch (SQLException e) {
            throw new DAOException("Error adding employee in DAO", e);
        }
    }

    @Override
    public void update(Employee emp) throws DAOException {
        String query = "UPDATE employee SET firstname = ?, lastname = ?, birthdate = ?, salary = ? WHERE id = ?";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, emp.getFirstName());
            stmt.setString(2, emp.getLastName());
            java.sql.Date sqlDate = new java.sql.Date(emp.getBirthDate().getTime());
            stmt.setDate(3, sqlDate);
            stmt.setFloat(4, emp.getSalary());
            stmt.setInt(5, emp.getId());

            if (stmt.executeUpdate() != 1) { throw new DAOException("Error updating employee"); }
        } catch (SQLException e) {
            throw new DAOException("Error updating employee", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        Employee emp = findById(id);
        if (emp == null) {
            throw new DAOException("Employee with id " + id + " not found");
        }

        String query = "DELETE FROM employee WHERE id = ?";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            if (stmt.executeUpdate() != 1) { throw new DAOException("Error deleting employee"); }
        } catch (SQLException e) {
            throw new DAOException("Error deleting employee", e);
        }
    }

    @Override
    public Employee findById(int id) throws DAOException {
        String query = "SELECT * FROM employee WHERE id = " + id;
        Employee emp = null;

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                emp = new Employee(rs.getInt("id"),
                                   rs.getString("firstname"),
                                   rs.getString("lastname"),
                                   rs.getDate("birthdate"),
                                   rs.getFloat("salary"));
            }
        } catch (SQLException e) {
            throw new DAOException("Error finding employee", e);
        }

        return emp;
    }

    @Override
    public Employee[] getAllEmployees() throws DAOException {
        List<Employee> emps = new ArrayList<Employee>();
        String query = "SELECT * FROM employee";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                emps.add(new Employee(rs.getInt("id"),
                         rs.getString("firstname"),
                         rs.getString("lastname"),
                         rs.getDate("birthdate"),
                         rs.getFloat("salary")));
            }

            return emps.toArray(new Employee[0]);
        } catch (SQLException e) {
            throw new DAOException("Error finding employees", e);
        }
    }

    @Override
    public void close() throws Exception {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e);
        }
    }
}
