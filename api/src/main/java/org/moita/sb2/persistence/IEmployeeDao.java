package org.moita.sb2.persistence;

import org.moita.sb2.model.Employee;

import java.util.Collection;
import java.util.Optional;

public interface IEmployeeDao {

    void addEmployee(Employee employee);

    void removeEmployee(long employeeId);

    void updateEmployee(Employee employee);

    Optional<Collection<Employee>> listEmployees();

    Optional<Employee> getEmployeeById(long employeeId);

    void insertDummy();
}