package com.ivanov_sergey.springbootbackend.controller;

import com.ivanov_sergey.springbootbackend.model.Employee;
import com.ivanov_sergey.springbootbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping( "/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}") // this {id} passing to the parameter of method
    public Employee getEmployee(@PathVariable Long id){ // @PathVariable is using for getting value of request from address
        Employee employee = employeeService.getEmployee(id);

        if (employee == null){
//            throw new NoSuchTestEntityException("There is no testEntity with ID = " + id + " in the DataBase");
        }
        return employee; //passing is not object employee and JSON, because Spring and Jackson
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){ //we are passing JSON? but Spring convert parameter to class
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateTestEntity(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        Employee employee = employeeService.getEmployee(id);
        if (employee == null){
//            throw new NoSuchTestEntityException("There is no Employee with ID = " + id + " in the DataBase");
        }


        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }

//    @GetMapping("/entities/name/{name}")
//    public List<TestEntity> showAllTestEntitiesByName(@PathVariable String name){
//        return  employeeService.findAllByName(name);
//    }

//    @ExceptionHandler
//    public ResponseEntity<TestEntityIncorrectData> handleException(NoSuchTestEntityException exception){
//        TestEntityIncorrectData data = new TestEntityIncorrectData();
//        data.setInfo(exception.getMessage());
//
//        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<TestEntityIncorrectData> handleException(Exception exception){
//        TestEntityIncorrectData data = new TestEntityIncorrectData();
//        data.setInfo(exception.getMessage());
//
//        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
//    }
}
