package org.moita.sb2.acceptance.converter;

import fitnesse.slim.Converter;
import org.moita.sb2.model.Employee;

public class EmployeeConverter implements Converter<Employee> {

    @Override
    public String toString(Employee employee) {
        return String.format("%s;%s", employee.getId(), employee.getName());
    }

    @Override
    public Employee fromString(String employeeStr) {
        Employee employee = new Employee();
        String[] attr = employeeStr.split(";");
        employee.setId(Long.valueOf(attr[0]));
        employee.setName(attr[1]);
        return employee;
    }
}
