package lab4.practice1.domain;

import lab4.practice1.Manager;

public class Director extends Manager {
    private final double budget;

    public Director(int empId, String name, String ssn, double salary, String deptName, double budget) {
        super(empId, name, ssn, salary, deptName);
        this.budget = budget;
    }

    public double getBudget() {
        return this.budget;
    }
}
