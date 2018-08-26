package org.moita.sb2.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {
        super();
    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
