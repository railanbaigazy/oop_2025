package lab4.practice;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    private final String deptName;
    private final List<Employee> staff;
    public Manager(int empId, String name, String ssn, double salary, String deptName) {
        super(empId, name, ssn, salary);
        this.deptName = deptName;
        this.staff = new ArrayList<Employee>(10);
    }

    public String getDeptName() {
        return this.deptName;
    }

    public int findEmployee(Employee target) {
//        for (Employee emp : staff) {
//            if (emp.equals(target)) {
//                return emp.getId();
//            }
//        }
//        return -1;
        return this.staff.indexOf(target);
    }
    public boolean addEmployee(Employee emp) {
        if (findEmployee(emp) != -1) {
            return false;
        }
        staff.add(emp);
        return true;
    }
    public boolean removeEmployee(Employee emp) {
        return staff.remove(emp);
    }
    public int getEmployeeCount() {
        return staff.size();
    }
}
