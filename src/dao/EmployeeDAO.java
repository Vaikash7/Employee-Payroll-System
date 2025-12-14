package dao;
import java.util.List;

import model.Employee;
public interface EmployeeDAO {

  public boolean addEmployee(Employee e);
  
  public List<Employee> getAllEmployees();

  public Employee getEmployeeById(int id);
  
  public boolean deleteEmployee(int id);
}
