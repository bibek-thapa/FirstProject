
package com.example.repository;



import com.example.data.Employee;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
