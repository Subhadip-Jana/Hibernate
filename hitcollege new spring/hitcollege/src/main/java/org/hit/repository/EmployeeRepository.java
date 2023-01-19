package org.hit.repository;

import org.hit.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public Employee deleteEmployee(Integer employeeId);
    public List<Employee> findAll();
    public Employee findById(Integer employeeId);

}
