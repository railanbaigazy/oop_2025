package lab1;

import lab1.domain.Employee;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.setId(101);
        emp1.setName("Jane Smith");
        emp1.setSsn("012-34-4567");
        emp1.setSalary(120345.27);

        System.out.println("Employee ID: " + emp1.getId());
        System.out.println("Employee Name: " + emp1.getName());
        System.out.println("Employee SSN: " + emp1.getSsn());
        System.out.println("Employee Salary: " + emp1.getSalary());

        Employee emp2 = new Employee();
        emp2.setId(102);
        emp2.setName("Harry Pinero");
        emp2.setSsn("012-34-4568");
        emp2.setSalary(120345.28);

        System.out.println("Employee ID: " + emp2.getId());
        System.out.println("Employee Name: " + emp2.getName());
        System.out.println("Employee SSN: " + emp2.getSsn());
        System.out.println("Employee Salary: " + emp2.getSalary());
    }
}
