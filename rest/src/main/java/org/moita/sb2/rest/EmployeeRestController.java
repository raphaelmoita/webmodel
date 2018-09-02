package org.moita.sb2.rest;

import org.moita.sb2.model.Employee;
import org.moita.sb2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public Collection<Employee> listar() {
        return employeeService.listEmployees();
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/remove/{employeeId}")
    public void removeEmployee(@PathVariable Long employeeId) {
        employeeService.removeEmployee(employeeId);
    }

    @GetMapping("/list/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }
}
