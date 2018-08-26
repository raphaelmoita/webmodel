package org.moita.sb2;

import org.moita.sb2.model.Employee;
import org.moita.sb2.service.SimpleCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class WebmodelApplication {

	@Autowired
	private SimpleCompanyService companyService;

	@PostConstruct
	public void execute() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Raphael");
		companyService.addEmployee(employee);
		companyService.listEmployees().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(WebmodelApplication.class, args);
	}
}
