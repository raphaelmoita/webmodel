package org.moita.sb2.persistence;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.moita.sb2.config.ConnectionSessionConfig;
import org.moita.sb2.mapper.EmployeeMapper;
import org.moita.sb2.model.Employee;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.Optional;

@Controller
public class EmployeeDao implements IEmployeeDao {

    private SqlSessionFactory session;

    public EmployeeDao(ConnectionSessionConfig sessionConfig) {
        session = sessionConfig.getSession();
    }

    public void addEmployee(Employee employee) {
        try (SqlSession openSession = session.openSession()) {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            mapper.insertEmployee(employee);
            openSession.commit();
        }
    }

    public void removeEmployee(long employeeId) {
        try (SqlSession openSession = session.openSession()) {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            mapper.removeEmployee(employeeId);
            openSession.commit();
        }
    }

    public void updateEmployee(Employee employee) {
        try (SqlSession openSession = session.openSession()) {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            mapper.updateEmployee(employee);
            openSession.commit();
        }
    }

    public Optional<Collection<Employee>> listEmployees() {
        try (SqlSession openSession = session.openSession()) {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            return Optional.of(mapper.findAllEmployees());
        }
    }

    public Optional<Employee> getEmployeeById(long employeeId) {
        try (SqlSession openSession = session.openSession()) {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            return Optional.ofNullable(mapper.findEmployeeById(employeeId));
        }
    }

    public void insertDummy() {
        try (SqlSession openSession = session.openSession()) {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            mapper.insertDummy();
            openSession.commit();
        }
    }
}
