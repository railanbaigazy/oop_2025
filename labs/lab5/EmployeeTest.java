package lab5;

import lab5.business.EmployeeStockPlan;
import lab5.domain.Admin;
import lab5.domain.Director;
import lab5.domain.Engineer;

public class EmployeeTest {
    public static void printEmployee(Employee emp) {
        System.out.println("\nEmployee type: " + emp.getClass().getSimpleName());
        System.out.println(emp);
    }

    public static void printEmployee(Employee emp, EmployeeStockPlan esp) {
        printEmployee(emp);
        System.out.println("Stock options: " + esp.grantStock(emp));
    }
    public static void main(String[] args) {
        Engineer engineer = new Engineer(101, "Jane Smith", "012-34-5678", 120_345.27);
        Manager manager = new Manager(207, "Barbara Johnson", "054-12-2367", 109_501.36, "US Marketing");
        Admin admin = new Admin(304, "Bill Monroe", "108-23-6509", 75_002.34);
        Director director = new Director(12, "Susan Wheeler", "099-45-2340", 120_567.36, "Global Marketing", 1_000_000.00);

        EmployeeStockPlan esp = new EmployeeStockPlan();

        System.out.println("====== Employees ======");
        printEmployee(engineer, esp);
        printEmployee(manager, esp);
        printEmployee(admin, esp);
        printEmployee(director, esp);
    }
}
