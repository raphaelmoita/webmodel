package org.moita.sb2.rest;

import org.moita.sb2.model.Employee;
import org.moita.sb2.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/rest/company")
public class CompanyRestController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/listar")
    public Collection<Employee> listar() {
        return companyService.listEmployees();
    }

    public void addEmployee(Employee employee) {
        companyService.addEmployee(employee);
    }

    public void removeEmployee(Employee employee) {
        companyService.removeEmployee(employee);
    }

    @GetMapping("/listar/{employeeId}")
    public Employee getEmployeeById(Long employeeId) {
        return companyService.getEmployeeById(employeeId);
    }

    public void updateEmployee(Employee employee) {
        companyService.updateEmployee(employee);
    }
}
