package org.moita.sb2.service;

import org.moita.sb2.model.Employee;

import java.util.Collection;

public interface CompanyService {

    Collection<Employee> listEmployees();

    void addEmployee(Employee employee);

    void removeEmployee(Employee employee);

    Employee getEmployeeById(long employeeId);

    void updateEmployee(Employee employee) ;
}