package lab7.EmployeeMemoryDAO.dao;

public class EmployeeDAOFactory {
    public EmployeeDAO createEmployeeDAO() {
        return new EmployeeDAOMemoryImpl();
    }
}
