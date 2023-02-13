package com.ivanov_sergey.springbootbackend.service;


import com.ivanov_sergey.springbootbackend.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);
    public Employee getEmployee(Long id);

    public void deleteEmployee(Long id);
//    public List<Employee> findAllByName(String name);
}
