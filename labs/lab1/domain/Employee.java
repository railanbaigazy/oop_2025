package lab1.domain;

public class Employee {
    public int id;
    public String name;
    public String ssn;
    public double salary;

    public Employee() {
        this.id = 0;
        this.name = "";
        this.ssn = "";
        this.salary = 0.0;
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

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
