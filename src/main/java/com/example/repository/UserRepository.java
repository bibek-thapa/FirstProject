package com.example.repository;

import com.example.data.UserDetail;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetail, Long> {
   //In interface method will be public by default 
     UserDetail findByUserName(String userName);
     UserDetail findByEmailAddress(String emailAddress);
}
