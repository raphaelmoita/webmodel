package org.moita.sb2.persistence;

import org.moita.sb2.model.Employee;

import java.util.Collection;

public interface ICompanyDao {

    void addEmployee(Employee employee);

    void removeEmployee(Employee employee);

    void updateEmployee(Employee employee);

    Collection<Employee> listEmployees();

    Employee getEmployeeById(long employeeId);
}