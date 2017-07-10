/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.data.UserRoles;

/**
 *
 * @author Dell
 */
public interface RoleRepository extends JpaRepository<UserRoles,Long> {
    
    UserRoles findByRole(String role);
}
