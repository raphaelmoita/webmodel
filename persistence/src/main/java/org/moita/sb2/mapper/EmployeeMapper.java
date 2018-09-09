package org.moita.sb2.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.moita.sb2.model.Employee;

import java.util.Collection;

@Mapper
public interface EmployeeMapper {

    void insertEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void removeEmployee(@Param("id") Long employeeId);

    Collection<Employee> findAllEmployees();

    Employee findEmployeeById(@Param("id") Long employeeId);

    void insertDummy();

}
