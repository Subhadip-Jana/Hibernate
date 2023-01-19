package org.hit;

import org.hit.config.SpringConfig;
import org.hit.model.Employee;
import org.hit.service.EmployeeService;
import org.hit.service.EmployeeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Scanner scan = new Scanner(System.in);
        int ch;
        EmployeeService service = context.getBean("employeeService",EmployeeService.class);
        Employee employee;
        Integer empid;
        do{
            System.out.println("\n1->Add 2->Update  3->Delete  4->Search  5->Display  6->Exit\n");
            ch = scan.nextInt();
            switch(ch){
                case 1 :
                    System.out.println("\n||Enter employee details||\n");
                    employee = context.getBean("employee",Employee.class);
                    System.out.print("Enter Employee Id: ");
                    employee.setEmployeeId(scan.nextInt());
                    System.out.print("Enter Employee Name: ");
                    employee.setEmployeeName(scan.next());
                    System.out.print("Enter Employee's Salary: ");
                    employee.setEmployeeSalary(scan.nextInt());
                    service.addEmployee(employee);
                    break;
                case 2:
                    System.out.print("\nEnter employee ID to modify : ");
                    empid = scan.nextInt();
                    employee = service.findById(empid);
                    if(employee == null){
                        System.out.println("Record not found!!");
                    }else{
                        System.out.println("Existing data : ");
                        System.out.println(employee);
                        System.out.println("Enter name and salary to update");
                        System.out.print("\nEnter Name: ");
                        employee.setEmployeeName(scan.next());
                        System.out.print("Enter Salary: ");
                        employee.setEmployeeSalary(scan.nextInt());
                        service.updateEmployee(employee);
                        System.out.println("Record updated successfully");
                    }
                    break;
                case 3:
                    System.out.print("\nEnter employee ID to delete :");
                    empid = scan.nextInt();
                    employee = service.findById(empid);
                    if(employee == null){
                        System.out.println("Record not found");
                    } else {
                        System.out.println("Deleted record ");
                        System.out.println(employee);
                        service.deleteEmployee(empid);
                        System.out.println("Record deleted successfully");
                    }
                    break;
                case 4:
                    System.out.print("\nEnter employee ID to search :");
                    empid = scan.nextInt();
                    employee = service.findById(empid);
                    if(employee == null){
                        System.out.println("Record not found");
                    }else {
                        System.out.println(employee);
                    }
                    break;
                case 5:
                    service.findAll().forEach(System.out::println);
                case 6:
                    break;
            }
        }while(ch != 6);
    }
}
