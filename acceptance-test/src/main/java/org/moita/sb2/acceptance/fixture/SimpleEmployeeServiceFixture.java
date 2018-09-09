package org.moita.sb2.acceptance.fixture;

import org.moita.sb2.acceptance.base.Fixture;
import org.moita.sb2.acceptance.base.FixtureWirer;
import org.moita.sb2.model.Employee;
import org.moita.sb2.service.SimpleEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class SimpleEmployeeServiceFixture implements Fixture {

    @Autowired
    private SimpleEmployeeService employeeService;

    public SimpleEmployeeServiceFixture() {
        FixtureWirer.wire(this);
    }

    public String listEmployees() {
        return "AA"; //return employeeService.listEmployees().toString();
    }

    public void setListEmployees(String employees) {

    }
}
