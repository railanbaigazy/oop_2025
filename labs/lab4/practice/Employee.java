package lab4.practice;

public class Employee {
    private final int id;
    private String name;
    private final String ssn;
    private double salary;

    public Employee(int empId, String name, String ssn, double salary) {
        this.id = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getSsn() {
        return this.ssn;
    }
    public double getSalary() {
        return this.salary;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void raiseSalary(double increase) {
        if (this.salary + increase > this.salary) {
            this.salary += increase;
        }
    }
}
