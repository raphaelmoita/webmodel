package org.moita.sb2.service;

import org.moita.sb2.acceptance.base.Fixture;
import org.moita.sb2.acceptance.base.FixtureWirer;
import org.springframework.beans.factory.annotation.Autowired;

public class SimpleEmployeeServiceFixture implements Fixture {

    @Autowired
    private SimpleEmployeeService employeeService;

    public SimpleEmployeeServiceFixture() {
        FixtureWirer.wire(this);
    }

    public String listEmployees() {
        return employeeService.listEmployees().toString();
    }
}
