package com.example.demo.Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository)
    {
        return args -> {
            Employee aish=new Employee(1,"Aishu","CSE");
            Employee aksh=new Employee(2,"Akshu","IT");
            repository.saveAll(List.of(aish,aksh));
        };
    }
}
