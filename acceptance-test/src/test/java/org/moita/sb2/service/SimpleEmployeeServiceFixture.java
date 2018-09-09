package org.moita.sb2.service;

import org.moita.sb2.acceptance.base.Fixture;
import org.moita.sb2.acceptance.base.FixtureWirer;
import org.moita.sb2.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class SimpleEmployeeServiceFixture implements Fixture {

    @Autowired
    private SimpleEmployeeService employeeService;

    public SimpleEmployeeServiceFixture() {
        FixtureWirer.wire(this);
    }

    public Collection<Employee> listEmployees() {
        return employeeService.listEmployees();
    }
}
