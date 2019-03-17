package org.moita.sb2.acceptance.base;

import org.moita.sb2.acceptance.converter.EmployeeConverter;
import org.moita.sb2.model.Employee;

import static fitnesse.slim.converters.ConverterRegistry.addConverter;

public abstract class AbstractFixture implements Fixture {

    public AbstractFixture(String methods) {
//        FixtureWirer.INSTANCE.wire(this);
        addConverter(Employee.class, new EmployeeConverter());
        preProcess(methods);
    }

    protected void preProcess(String methodNames) {
        String[] methods = methodNames.split(",");
        for (String method : methods) {
            switch (method) {
                case "clean":
                    clean();
            }
        }
    }

    protected abstract void clean();
}
