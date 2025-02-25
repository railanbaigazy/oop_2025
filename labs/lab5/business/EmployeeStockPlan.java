package lab5.business;

import lab5.Employee;
import lab5.Manager;
import lab5.domain.Director;

public class EmployeeStockPlan {
    public final int directorShares = 1000;
    public final int managerShares = 100;
    public final int employeeShares = 10;

    public int grantStock(Employee emp) {
        if (emp instanceof Director) {
            return directorShares;
        }
        if (emp instanceof Manager) {
            return managerShares;
        }
        return employeeShares;
    }
}
