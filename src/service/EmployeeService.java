package service;

import java.util.List;

import dao.EmployeeDAOImpl;
import model.Employee;

public class EmployeeService {

  EmployeeDAOImpl dao=new EmployeeDAOImpl();

    public boolean addEmployee(Employee e){
      return dao.addEmployee(e);
  }

    public List<Employee> getAllEmployees(){
      return dao.getAllEmployees();
  }

  public Employee getEmployeeById(int id){
    return dao.getEmployeeById(id);
  }

  public boolean deleteEmployee(int id){
    return dao.deleteEmployee(id);
  }
}
