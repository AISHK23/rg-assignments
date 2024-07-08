package com.example.demo.Employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

@Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees()
    {
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional=employeeRepository.findEmployeeById(employee.getId());
        if(employeeOptional.isPresent())
        {
            throw new IllegalStateException("id taken");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
      boolean exists=employeeRepository.existsById(id);
      if(!exists)
      {
          throw new IllegalStateException("Employee does not exist");
      }
      employeeRepository.deleteById(id);

    }
    @Transactional
    public void updateEmployee(Integer id, String name, String department) {
     Employee employee=employeeRepository.findEmployeeById(id).orElseThrow(() -> new IllegalStateException("Employee not found"));
     employee.setName(name);
     employee.setDepartment(department);
    }
}
