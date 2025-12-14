package model;
public class Employee {

  private int empId;
  private String empName;
  private String empRole;
  private Double salary;

  public Employee(){

  }

  public Employee(int empId, String empName, String empRole, Double salary) {
    this.empId = empId;
    this.empName = empName;
    this.empRole = empRole;
    this.salary = salary;
  }

  public int getEmpId() {
    return empId;
  }

  public void setEmpId(int empId) {
    this.empId = empId;
  }

  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public String getEmpRole() {
    return empRole;
  }

  public void setEmpRole(String empRole) {
    this.empRole = empRole;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

}
