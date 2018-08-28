package org.moita.sb2.service;

import org.moita.sb2.exception.EmployeeNotFoundException;
import org.moita.sb2.model.Employee;
import org.moita.sb2.persistence.ICompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.Optional;

@Controller
public class SimpleCompanyService implements CompanyService {

    @Autowired
    private ICompanyDao companyDao;

    public Collection<Employee> listEmployees() {
        throw new EmployeeNotFoundException("opssss");
//        Optional<Collection<Employee>> employees = companyDao.listEmployees();
//        return employees.orElseThrow(EmployeeNotFoundException::new);
    }

    public void addEmployee(Employee employee) {
        companyDao.addEmployee(employee);
    }

    public void removeEmployee(Employee employee) {
        companyDao.removeEmployee(employee);
    }

    public Employee getEmployeeById(long employeeId) {
        Optional<Employee> employee = companyDao.getEmployeeById(employeeId);
        return employee.orElseThrow(EmployeeNotFoundException::new);
    }

    public void updateEmployee(Employee employee) {
        companyDao.updateEmployee(employee);
    }
}
