package lab9.SimpleJDBCExample;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SimpleJDBCExample {
    public static void main(String[] args) throws ParseException {
        // Create the "url"
        // assume database server is running on the localhost
        String url = "jdbc:postgresql://localhost:5432/employeedb";
        String username = "postgres";
        String password = "postgres";

        Scanner scanner = new Scanner(System.in);

        System.out.println("[Insert employee details]");
        System.out.println("Enter employee ID: ");
        int idInp = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your first name: ");
        String firstNameInp = scanner.nextLine();
        System.out.println("Enter your second name: ");
        String secondNameInp = scanner.nextLine();
        System.out.println("Enter your birthday (DD/MM/YYYY): ");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date birthdayInp = formatter.parse(scanner.nextLine());
        System.out.println("Enter your salary: ");
        float salaryInp = scanner.nextFloat();

        String insertQuery = "INSERT INTO employee (id, firstname, lastname, birthdate, salary) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(insertQuery)) {
            stmt.setInt(1, idInp);
            stmt.setString(2, firstNameInp);
            stmt.setString(3, secondNameInp);
            java.sql.Date sqlDate = new java.sql.Date(birthdayInp.getTime());
            stmt.setDate(4, sqlDate);
            stmt.setFloat(5, salaryInp);
            stmt.executeUpdate();
            System.out.println("Employee details inserted\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Create a simple query
        String query = "SELECT * FROM employee";

        // A try-with-resources example
        // Connection and Statement implement java.lan.AutoCloseable
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("EMPLOYEES LIST");
            while (rs.next()) {
                int empID = rs.getInt("id");
                String first = rs.getString("firstname");
                String last = rs.getString("lastname");
                Date birth_date = rs.getDate("birthdate");
                float salary = rs.getFloat("salary");
                System.out.println("Employee ID:   " + empID + "\n"
                        + "Employee Name: " + first.trim() + " " + last.trim() + "\n"
                        + "Birth Date:    " + birth_date + "\n"
                        + "Salary:        " + salary + "\n");

            }
        } catch (Exception e) {
            System.out.println("Exception creating connection: " + e);
            System.exit(0);
        }
        // No need to close the Connection and Statement objects, the compiler
        // will generate these for us and call the close() statement on this
        // objects in the order we obtained them in the try
    }
}