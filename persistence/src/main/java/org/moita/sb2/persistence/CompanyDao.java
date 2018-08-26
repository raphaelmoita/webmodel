package org.moita.sb2.persistence;

import org.moita.sb2.model.Employee;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class CompanyDao implements ICompanyDao {

    private Map<Long, Employee> employees = new ConcurrentHashMap<>();

    public void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    public void removeEmployee(Employee employee) {

    }

    public void updateEmployee(Employee employee) {

    }

    public Collection<Employee> listEmployees() {
        return employees.values();
    }

    public Employee getEmployeeById(long employeeId) {
        return null;
    }
}
