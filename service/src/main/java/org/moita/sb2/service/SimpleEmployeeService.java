package org.moita.sb2.service;

import org.moita.sb2.exception.EmployeeNotFoundException;
import org.moita.sb2.model.Employee;
import org.moita.sb2.persistence.IEmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.Optional;

@Controller
public class SimpleEmployeeService implements EmployeeService {

    @Autowired
    private IEmployeeDao employeeDao;

    public Collection<Employee> listEmployees() {
        Optional<Collection<Employee>> employees = employeeDao.listEmployees();
        return employees.orElseThrow(EmployeeNotFoundException::new);
    }

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public void removeEmployee(long employeeId) {
        employeeDao.removeEmployee(employeeId);
    }

    public Employee getEmployeeById(long employeeId) {
        Optional<Employee> employee = employeeDao.getEmployeeById(employeeId);
        return employee.orElseThrow(EmployeeNotFoundException::new);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public void insertDummy() {
        employeeDao.insertDummy();
    }
}
