package org.hit.service;

import org.hit.model.Employee;
import org.hit.repository.EmployeeRepository;
import org.hit.repository.hibernate.EmployeeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean addEmployee(Employee employee) {

        if(employeeRepository.addEmployee(employee) == null)
            return false;
        else
            return true;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        if(employeeRepository.updateEmployee(employee) == null)
            return false;
        else
            return true;
    }

    @Override
    public boolean deleteEmployee(Integer employeeID) {
        if(employeeRepository.deleteEmployee(employeeID) == null)
            return false;
        else
            return true;
    }

    @Override
    public Employee findById(Integer employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
