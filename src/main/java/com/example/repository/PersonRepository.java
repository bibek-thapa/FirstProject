
package com.example.repository;

import com.example.data.Person;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
