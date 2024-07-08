package com.example.Employee_Spring.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Employee employee)
    {
        String query="insert into Employee (id,name,department) values(?,?,?)";
        template.update(query,employee.getId(),employee.getName(),employee.getDepartment());
        System.out.println("Employee added");
    }
    public List<Employee> getEmployees()
    {
        String query= "select * from Employee";
        RowMapper<Employee> employeeRowMapper=new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee emp=new Employee();
                emp.setId(rs.getInt(1));
                emp.setName(rs.getString(2));
                emp.setDepartment(rs.getString(3));
                return emp;
            }
        };
        List<Employee> em = template.query(query,employeeRowMapper);
        return em;
    }
    public void deleteEmployee(int id)
    {
        String query="delete from Employee where id=?";
        template.update(query,id);
        System.out.println("Employee deleted");
    }
    public void updateEmployee(int id,String department)
    {
        String query="update Employee set department=? where id=?";
        template.update(query,department,id);
        System.out.println("Employee updated");
    }

}
