package com.example.repository;

import com.example.data.Department;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
}
