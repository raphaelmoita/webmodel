package org.moita.sb2.acceptance.fixture;

import org.moita.sb2.acceptance.base.Fixture;
import org.moita.sb2.acceptance.base.FixtureWirer;
import org.moita.sb2.acceptance.converter.EmployeeConverter;
import org.moita.sb2.model.Employee;
import org.moita.sb2.service.SimpleEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static fitnesse.slim.converters.ConverterRegistry.addConverter;

public class SimpleEmployeeServiceFixture implements Fixture {

    @Autowired
    private SimpleEmployeeService employeeService;

    private long id;
    private Employee employee;

    public SimpleEmployeeServiceFixture(String methods) {
        FixtureWirer.INSTANCE.wire(this);
        addConverter(Employee.class, new EmployeeConverter());
        preProcess(methods);
    }

    public Collection<Employee> listEmployees() {
        return employeeService.listEmployees();
    }

    public Employee getEmployeeById() {
        return employeeService.getEmployeeById(employee.getId());
    }

    public void setEmployee(String employee) {
        this.employee = new EmployeeConverter().fromString(employee);
        employeeService.addEmployee(this.employee);
    }

    private void clean() {
        Collection<Employee> employees = employeeService.listEmployees();
        employees.stream()
                .map(Employee::getId)
                .forEach(employeeService::removeEmployee);
    }

    private void preProcess(String methodNames) {
        String[] methods = methodNames.split(",");
        for (String method : methods) {
            switch (method) {
                case "clean":
                    clean();
            }
        }
    }
}
