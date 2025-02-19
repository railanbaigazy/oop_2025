package lab4.practice1;

import lab4.practice1.domain.Admin;
import lab4.practice1.domain.Director;
import lab4.practice1.domain.Engineer;

import java.text.NumberFormat;

public class EmployeeTest {
    public static void printEmployee(Employee emp) {
        System.out.println("\nID:     " + emp.getId());
        System.out.println("Name:   " + emp.getName());
        System.out.println("SSN:    " + emp.getSsn());
        System.out.println("Salary: " + NumberFormat.getCurrencyInstance().format(emp.getSalary()));
    }

    public static void main(String[] args) {
        Engineer engineer = new Engineer(101, "Jane Smith", "012-34-5678", 120_345.27);
        Manager manager = new Manager(207, "Barbara Johnson", "054-12-2367", 109_501.36, "US Marketing");
        Admin admin = new Admin(304, "Bill Monroe", "108-23-6509", 75_002.34);
        Director director = new Director(12, "Susan Wheeler", "099-45-2340", 120_567.36, "Global Marketing", 1_000_000.00);

        System.out.println("====== Employees ======");
        printEmployee(engineer);
        printEmployee(manager);
        printEmployee(admin);
        printEmployee(director);

        manager.raiseSalary(500);
        engineer.raiseSalary(750);
        admin.setName("Railan Johnson");
        System.out.println("==== Updated Employees ====");
        printEmployee(manager);
        printEmployee(engineer);
        printEmployee(admin);


    }
}
