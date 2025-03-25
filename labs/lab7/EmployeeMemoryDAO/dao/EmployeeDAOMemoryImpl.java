package lab7.EmployeeMemoryDAO.dao;

import lab7.EmployeeMemoryDAO.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOMemoryImpl implements EmployeeDAO {
    private static Employee[] employeeArray = new Employee[10];

    protected EmployeeDAOMemoryImpl() {}

    public void add(Employee employee) {
        employeeArray[employee.getId()] = employee;
    }

    public void update(Employee employee) {
        employeeArray[employee.getId()] = employee;
    }

    public void delete(int id) {
        employeeArray[id] = null;
    }

    public Employee findById(int id) {
        return employeeArray[id];
    }

    public Employee[] getAllEmployees() {
        List<Employee> emps = new ArrayList<>();
        for (Employee e : employeeArray) {
            if (e != null) {
                emps.add(e);
            }
        }
        return emps.toArray(new Employee[0]);
    }

}
