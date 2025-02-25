package lab5.domain;

import lab5.Manager;

import java.text.NumberFormat;

public class Director extends Manager {
    private final double budget;

    public Director(int empId, String name, String ssn, double salary, String deptName, double budget) {
        super(empId, name, ssn, salary, deptName);
        this.budget = budget;
    }

    public double getBudget() {
        return this.budget;
    }

    @Override
    public String toString() {
        return """
            %s
            Budget: %s""".formatted(super.toString(), NumberFormat.getCurrencyInstance().format(getBudget()));
    }
}
