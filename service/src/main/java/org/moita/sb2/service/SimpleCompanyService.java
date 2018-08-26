package org.moita.sb2.service;

import org.moita.sb2.model.Employee;
import org.moita.sb2.persistence.ICompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class SimpleCompanyService implements CompanyService {

    @Autowired
    private ICompanyDao companyDao;

    public Collection<Employee> listEmployees() {
        return companyDao.listEmployees();
    }

    public void addEmployee(Employee employee) {
        companyDao.addEmployee(employee);
    }

    public void removeEmployee(Employee employee) {
        companyDao.removeEmployee(employee);
    }

    public Employee getEmployeeById(long employeeId) {
        return companyDao.getEmployeeById(employeeId);
    }

    public void updateEmployee(Employee employee) {
        companyDao.updateEmployee(employee);
    }
}
