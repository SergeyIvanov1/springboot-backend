package com.ivanov_sergey.springbootbackend.repositiry;



import com.ivanov_sergey.springbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    public List<Employee> findAllByName(String name);
}
