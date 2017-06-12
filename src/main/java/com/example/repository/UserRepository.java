package com.example.repository;

import com.example.data.User;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    public User findByUserName(String userName);
}
