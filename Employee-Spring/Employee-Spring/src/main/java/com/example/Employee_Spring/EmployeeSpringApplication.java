package com.example.Employee_Spring;

import com.example.Employee_Spring.Employee.Employee;
import com.example.Employee_Spring.Employee.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeeSpringApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(EmployeeSpringApplication.class, args);
		Employee employee=context.getBean(Employee.class);
		Employee employee1=context.getBean(Employee.class);
		EmployeeRepository repo=context.getBean(EmployeeRepository.class);
		employee1.setId(1);
		employee1.setName("aish");
		employee1.setDepartment("cse");
		employee.setId(2);
		employee.setName("aksh");
		employee.setDepartment("CSE");
		repo.save(employee);
		repo.save(employee1);
		System.out.println("List of employees:");
		System.out.println(repo.getEmployees());
		repo.deleteEmployee(2);
		System.out.println("List of employees:");
		System.out.println(repo.getEmployees());
		repo.updateEmployee(1,"CSE");
		System.out.println("List of employees:");
		System.out.println(repo.getEmployees());
	}

}
