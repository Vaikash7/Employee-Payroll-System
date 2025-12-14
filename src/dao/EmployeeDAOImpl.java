package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO{

  public boolean addEmployee(Employee e){
    String sql="INSERT INTO employee VALUES (?,?,?,?)";
    try(Connection con=DBConnection.getConnection()){
      PreparedStatement ps=con.prepareStatement(sql);
      ps.setInt(1, e.getEmpId());
      ps.setString(2, e.getEmpName());
      ps.setString(3, e.getEmpRole());
      ps.setDouble(4, e.getSalary());
      return ps.executeUpdate()>0;
    }catch(Exception er){
      er.printStackTrace();
    }
    return false;
  }
  
  public List<Employee> getAllEmployees(){
    List<Employee> list=new ArrayList<>();
    String sql="SELECT * FROM employee";
    try(Connection con=DBConnection.getConnection()){
      PreparedStatement ps=con.prepareStatement(sql);
      ResultSet rs=ps.executeQuery();
      while (rs.next()) {
        Employee e=new Employee();
        e.setEmpId(rs.getInt("empId"));
        e.setEmpName(rs.getString("empName"));
        e.setEmpRole(rs.getString("empRole"));
        e.setSalary(rs.getDouble("salary"));
        list.add(e);
      }
    }catch(Exception e){
      e.printStackTrace();
    }
    return list;
  }

  public Employee getEmployeeById(int id){
    String sql="SELECT * FROM employee WHERE empId=?";
    try(Connection con=DBConnection.getConnection()){
    PreparedStatement ps=con.prepareStatement(sql);
    ps.setInt(1, id);
    ResultSet rs=ps.executeQuery();
    if(rs.next()){
      Employee e=new Employee();
      e.setEmpId(rs.getInt("empId"));
      e.setEmpName(rs.getString("empName"));
      e.setEmpRole(rs.getString("empRole"));
      e.setSalary(rs.getDouble("salary"));
      return e;
    }
    }catch(Exception e){
      e.printStackTrace();
    }
    return null;
  }

  public boolean deleteEmployee(int id){
    String sql="DELETE FROM employee WHERE empId=?";
    try(Connection con=DBConnection.getConnection()){
      PreparedStatement ps=con.prepareStatement(sql);
      ps.setInt(1, id);
      return ps.executeUpdate()>0;
    }catch(Exception e){
      e.printStackTrace();
    }
    return false;
  }
}
