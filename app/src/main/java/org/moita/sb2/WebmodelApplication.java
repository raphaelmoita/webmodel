package org.moita.sb2;

import org.moita.sb2.model.Employee;
import org.moita.sb2.service.SimpleEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class WebmodelApplication {

	@Autowired
	private SimpleEmployeeService employeeService;

	@PostConstruct
	public void execute() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Raphael");
//		employeeService.addEmployee(employee);
//		employeeService.listEmployees().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(WebmodelApplication.class, args);
	}
}
