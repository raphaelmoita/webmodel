package org.moita.sb2.service;

import org.moita.sb2.model.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@Profile("fitnesse")
public class SimpleEmployeeServiceMock implements EmployeeService {

    public Collection<Employee> listEmployees() {
        return Collections.emptyList();
    }

    public void addEmployee(Employee employee) {
        new Employee();
    }

    public void removeEmployee(long employeeId) {

    }

    public Employee getEmployeeById(long employeeId) {
        Employee employee = new Employee();
        employee.setId(666);
        employee.setName("Mocked Employee");

        return employee;
    }

    public void updateEmployee(Employee employee) {

    }

//    @Override
    public void insertDummy() {

    }
}
