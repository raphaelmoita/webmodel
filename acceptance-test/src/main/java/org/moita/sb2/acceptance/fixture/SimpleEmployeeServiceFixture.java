package org.moita.sb2.acceptance.fixture;

import org.moita.sb2.acceptance.base.AbstractFixture;
import org.moita.sb2.acceptance.converter.EmployeeConverter;
import org.moita.sb2.model.Employee;
import org.moita.sb2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

public class SimpleEmployeeServiceFixture extends AbstractFixture {

    @Autowired
    private EmployeeService employeeService;

    private long id;
    private Employee employee;

    public SimpleEmployeeServiceFixture(String methods) {
        super(methods);
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

    @Override
    public void clean() {
        Collection<Employee> employees = employeeService.listEmployees();
        employees.stream()
                .map(Employee::getId)
                .forEach(employeeService::removeEmployee);
    }

    public List<List<List<String>>> query() {
        List<List<List<String>>> result = new ArrayList<>();
        listEmployees().forEach(e -> {
                        result.add(asList( // row level
                                asList("id", String.valueOf(e.getId())),
                                asList("name", e.getName())));
                        });
        return result;
    }

//    public List<List<List<String>>> _query() {
//
//        return
//                asList( // table level
//                        asList( // row level
//                                asList("id", "4"),
//                                asList("name", "Raphael")
//                        ),
//                        asList(
//                                asList("id", "5"),
//                                asList("name", "Rapha")
//                        ),
//                        asList(
//                                asList("id", "6"),
//                                asList("name", "Joao")
//                        )
//                );
//    }
}
