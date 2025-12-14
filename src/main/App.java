package main;
import java.util.*;
import model.Employee;
import service.EmployeeService;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        EmployeeService service =new EmployeeService();
        int choice;
        do{
            System.out.println("===== EMPLOYEE PAYROLL MANAGEMENT =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee By Id");
            System.out.println("4. Delete Employee");
            System.out.println("5. Update Salary");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice=sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Id: ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name=sc.nextLine();
                    System.out.print("Enter Role: ");
                    String role=sc.nextLine();
                    System.out.print("Enter Salary: ");
                    Double salary=sc.nextDouble();
                    Employee e=new Employee(id, name, role, salary);
                    if(service.addEmployee(e)){
                        System.out.println("Employee Added");
                    }else{
                        System.out.println("Employee not Addded");
                    }
                    break;

                case 2:
                    List<Employee> list=service.getAllEmployees();
                    if(list.isEmpty()){
                        System.out.println("No Employees Found");
                    }else{
                        for(Employee record: list){
                            System.out.println("empId: "+record.getEmpId()+" | empName: "+record.getEmpName()+" | empRole: "+record.getEmpRole()+" | salary: "+record.getSalary());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee Id: ");
                    int EmpID=sc.nextInt();
                    Employee found=service.getEmployeeById(EmpID);
                    if(found == null){
                    System.out.println("No Employee Found");
                    }else{
                        System.out.println("empId: "+found.getEmpId()+" | empName: "+found.getEmpName()+" | empRole: "+found.getEmpRole()+" | salary: "+found.getSalary());
                    }
                default:
                    break;

                case 4:
                    System.out.print("Enter Employee Id: ");
                    int delId=sc.nextInt();
                    if(service.deleteEmployee(delId)){
                        System.out.println("Employee Deleted");
                    }else{
                        System.out.println("Employee Not Found");
                    } break;
            }
                
        }while(choice!=6);
    }
}
